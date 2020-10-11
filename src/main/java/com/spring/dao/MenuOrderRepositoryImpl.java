package com.spring.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.MenuOrderEntity;

@Repository
@Transactional
public class MenuOrderRepositoryImpl extends BaseRepository implements MenuOrderRepository {
	
	private static final Logger LOGGER = Logger.getLogger(MenuOrderRepositoryImpl.class);
	
	public void save(MenuOrderEntity menuOrder) {
		
		System.out.println(menuOrder);
		
		LOGGER.info("Save menu order");
		getSession().save(menuOrder);
		LOGGER.info("Save menu order success");
	}

}
