package com.spring.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MenuRepository;
import com.spring.entity.MenuEntity;
import com.spring.model.MenuModel;
import com.spring.model.SearchMenuModel;
import com.spring.util.ModelUtil;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private static final Logger LOGGER = Logger.getLogger(RestaurantServiceImpl.class);

	@Autowired
	MenuRepository menuRepository;
	
	@Transactional
	public List<MenuModel> fetchMenu(SearchMenuModel searchModel) {
		
		Set<MenuEntity> entityList = menuRepository.fetch(ModelUtil.parse(searchModel));
		List<MenuModel> modelList = entityList.stream().map(ModelUtil::parse).collect(Collectors.toList());

		LOGGER.info("Fetch all menu success");
		return modelList;
	}
}
