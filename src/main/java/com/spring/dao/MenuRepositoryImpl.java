package com.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.MenuEntity;

@Transactional
@Repository
public class MenuRepositoryImpl extends BaseRepository implements MenuRepository {

	private static final Logger LOGGER = Logger.getLogger(MenuRepositoryImpl.class);
	
	public List<MenuEntity> fetch() {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<MenuEntity> query = builder.createQuery(MenuEntity.class);
		Root<MenuEntity> root = query.from(MenuEntity.class);
		query.select(root);
		List<MenuEntity> result = getSession().createQuery(query).getResultList();
		
		LOGGER.info("Fetch success with " + result.size() + " items in list");
		return result;
	}
}
