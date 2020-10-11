package com.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MenuOrderRepository;
import com.spring.dto.MenuOrderItemInfo;
import com.spring.model.MenuOrderItemInfoModel;
import com.spring.util.ModelUtil;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {

	private static final Logger LOGGER = Logger.getLogger(AdminOrderServiceImpl.class);
	
	@Autowired
	private MenuOrderRepository menuOrderRepository;
	
	@Transactional
	public List<MenuOrderItemInfoModel> fetchPendingOrder() {
		
		List<MenuOrderItemInfo> orders = menuOrderRepository.fetchPendingOrder();
		
		// Parse to model object
		List<MenuOrderItemInfoModel> models = orders.stream().map(order -> ModelUtil.parse(order)).collect(Collectors.toList());
		
		LOGGER.info("Fetch pending order success");
		return models;
	}
}
