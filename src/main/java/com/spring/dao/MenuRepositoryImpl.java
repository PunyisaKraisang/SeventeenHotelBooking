package com.spring.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.KeywordCategory;
import com.spring.dto.SearchMenu;
import com.spring.entity.MenuEntity;
import com.spring.entity.MenuKeywordEntity;

@Transactional
@Repository
public class MenuRepositoryImpl extends BaseRepository implements MenuRepository {

	private static final Logger LOGGER = Logger.getLogger(MenuRepositoryImpl.class);
	
	@Override
	public Set<MenuEntity> fetch(SearchMenu searchMenu) {
		
		// A problem occur when query with keyword
		// Only the menu_keyword's row that matched the SearchMenu will return and join with 
		// menu entity. The menu list result is correct but then we miss the other keywords that
		// also belong to particular menu. Will solve the problem by firing 2 query: 
		// 1. filter the correct menu using criteria and project only menuId
		// 2. retrieve menu information and its corresponding keywords by menuId from 1.
		
		// 1. fetch menu ID by SearchMenu
		Set<Integer> menuIdSet = fetchMenuId(searchMenu);
		
		// 2. retrieve menu entity by ID
		Set<MenuEntity> result = fetchMenu(menuIdSet);
		
		return result;
	}
	
	@Override
	public List<MenuKeywordEntity> fetchKeyword(List<KeywordCategory> categories) {
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<MenuKeywordEntity> query = builder.createQuery(MenuKeywordEntity.class);
		Root<MenuKeywordEntity> root = query.from(MenuKeywordEntity.class);
		
		// Only filter when categories are given
		if (categories.size() > 0) {
			LOGGER.info("Fetch all menu keywords in " + categories);
			In<String> inClause = builder.in(root.get("category"));
			
			// Add categories in inClause
			categories.forEach(category -> inClause.value(category.code));
			
			query.select(root).where(inClause);
			
		} else {
			LOGGER.info("Fetch all menu keywords");
			query.select(root);
		}
		
		// Fetch result
		List<MenuKeywordEntity> result = getSession().createQuery(query).getResultList();
		
		LOGGER.info("Fetch menu keyword success with " + result.size() + " items in list");
		return result;
	}
	
	private Set<Integer> fetchMenuId(SearchMenu searchMenu) {
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
		Root<MenuEntity> root = query.from(MenuEntity.class);
		
		// Left join 
		Join<MenuEntity, MenuKeywordEntity> menuKeyword = root.join("keywords", JoinType.LEFT);
		
		// Add all search criteria
		List<Predicate> predicates = buildCriteria(builder, searchMenu, root, menuKeyword);
		query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])) );
		
		// Project only menu ID
		query.select(root.get("menuId"));
		
		// Fetch result as menu ID
		Set<Integer> result = new LinkedHashSet<Integer>(
				getSession().createQuery(query).getResultList());

		LOGGER.info("Fetch menu ID success with " + result.size() + " items in list");
		return result;
	}
	
	private Set<MenuEntity> fetchMenu(Set<Integer> menuIdSet) {
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<MenuEntity> query = builder.createQuery(MenuEntity.class);
		Root<MenuEntity> root = query.from(MenuEntity.class);
		
		// Left join with fetch 
		root.fetch("keywords", JoinType.LEFT);
		
		// Add in criteria by menu ID 
		In<Integer> inClause =  builder.in(root.get("menuId"));
		menuIdSet.forEach(id -> inClause.value(id));
		query.where(inClause);
		
		// Fetch result
		Set<MenuEntity> result = new LinkedHashSet<MenuEntity>(
				getSession().createQuery(query).getResultList());
		
		LOGGER.info("Fetch menu success with " + result.size() + " items in list");
		return result;
	}
	
	private List<Predicate> buildCriteria(
			CriteriaBuilder builder, 
			SearchMenu searchMenu, 
			Root<MenuEntity> root,
			Join<MenuEntity, MenuKeywordEntity> menuKeyword) {
		LOGGER.info("Build criteria for search menu");
		List<Predicate> predicates = new ArrayList<>();
		
		if (searchMenu.isRecommended()) {
			LOGGER.info("> Add recommended criteria");
			predicates.add(builder.equal(root.get("isRecommended"), 1));
		}
		
		if (searchMenu.getName() != null && !searchMenu.getName().isEmpty()) {
			LOGGER.info("> Add name criteria");
			predicates.add(
					builder.like(
							builder.lower(root.get("name")), 
							"%" + searchMenu.getName().toLowerCase() + "%"));
		}
		
		if (searchMenu.getEthnicId() != -1 && searchMenu.getDietaryId() != -1) {
			LOGGER.info("> Add ethnic and dietary keywords criteria");
			predicates.add(
					builder.or(
							builder.equal(menuKeyword.get("keywordId"), searchMenu.getEthnicId()),
							builder.equal(menuKeyword.get("keywordId"), searchMenu.getDietaryId())));
			
		} else if(searchMenu.getEthnicId() != -1) {
			LOGGER.info("> Add ethnic keyword criteria");
			predicates.add(builder.equal(menuKeyword.get("keywordId"), searchMenu.getEthnicId()));
			
		} else if (searchMenu.getDietaryId() != -1) {
			LOGGER.info("> Add dietary keyword criteria");
			predicates.add(builder.equal(menuKeyword.get("keywordId"), searchMenu.getDietaryId()));
		}
		
		if (searchMenu.getMin() != 0 && searchMenu.getMax() != 0) {
			LOGGER.info("> Add min criteria");
			predicates.add(builder.greaterThanOrEqualTo(root.get("price"), searchMenu.getMin()));

			LOGGER.info("> Add max criteria");
			predicates.add(builder.lessThanOrEqualTo(root.get("price"), searchMenu.getMax()));
			
		}
		
		return predicates;
	}
}
