package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MenuOrderRepository;
import com.spring.dao.MenuRepository;
import com.spring.dto.KeywordCategory;
import com.spring.entity.MenuEntity;
import com.spring.entity.MenuKeywordEntity;
import com.spring.entity.MenuOrderEntity;
import com.spring.model.MenuKeywordModel;
import com.spring.model.MenuModel;
import com.spring.model.SaveMenuOrderModel;
import com.spring.model.SearchMenuModel;
import com.spring.util.ModelUtil;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private static final Logger LOGGER = Logger.getLogger(RestaurantServiceImpl.class);

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private MenuOrderRepository menuOrderRepository;
	
	@Override
	@Transactional
	public List<MenuModel> fetchMenu(SearchMenuModel searchModel) {
		
		Set<MenuEntity> entityList = menuRepository.fetch(ModelUtil.parse(searchModel));
		List<MenuModel> modelList = entityList.stream().map(ModelUtil::parse).collect(Collectors.toList());

		LOGGER.info("Fetch all menu success");
		return modelList;
	}

	@Override
	@Transactional
	public List<MenuKeywordModel> fetchMenuKeyword(KeywordCategory category) {
		LOGGER.info("Fetch menu keywords: " + category);
		
		List<KeywordCategory> keywords = new ArrayList<KeywordCategory>();
		keywords.add(category);
		List<MenuKeywordEntity> entityList = menuRepository.fetchKeyword(keywords);
		List<MenuKeywordModel> modelList = entityList.stream().map(ModelUtil::parse).collect(Collectors.toList());

		LOGGER.info("Fetch menu keywords success: " + category);
		return modelList;
	}
	
	@Transactional
	public void makeOrder(String username, SaveMenuOrderModel orderModel) {
		LOGGER.info("Make order");
		
		menuOrderRepository.save(ModelUtil.parse(username, orderModel));

		LOGGER.info("Make order success");
	}
}
