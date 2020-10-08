package com.spring.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.SearchMenu;
import com.spring.entity.MenuEntity;
import com.spring.entity.MenuKeywordEntity;

@Transactional
@Repository
public class MenuRepositoryImpl extends BaseRepository implements MenuRepository {

	private static final Logger LOGGER = Logger.getLogger(MenuRepositoryImpl.class);
	
	@SuppressWarnings("unchecked")
	public Set<MenuEntity> fetch(SearchMenu searchMenu) {
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<MenuEntity> query = builder.createQuery(MenuEntity.class);
		Root<MenuEntity> root = query.from(MenuEntity.class);
		
		// Left join with fetch 
		Fetch<MenuEntity, MenuKeywordEntity> menuKeywordFetch = root.fetch("keywords", JoinType.LEFT);
		Join<MenuEntity, MenuKeywordEntity> menuKeyword = (Join<MenuEntity, MenuKeywordEntity>) menuKeywordFetch;
		
		// Add all search criteria
		List<Predicate> predicates = buildCriteria(builder, searchMenu, root, menuKeyword);
		query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])) );
		
		// Fetch result
		Set<MenuEntity> result = new LinkedHashSet<MenuEntity>(
				getSession().createQuery(query).getResultList());
		
		LOGGER.info("Fetch success with " + result.size() + " items in list");
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
		
		return predicates;
	}
}
