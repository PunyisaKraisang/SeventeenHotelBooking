package com.spring.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.MenuOrderRepository;
import com.spring.dto.DeliverMenuOrderItem;
import com.spring.dto.MenuOrderItemInfo;
import com.spring.entity.MenuOrderItemEntity;
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
	
	@Transactional
	public void deliverOrder(DeliverMenuOrderItem orderItem) {
		
		MenuOrderItemEntity entity = menuOrderRepository.loadOrderItem(orderItem.getOrderId(), orderItem.getMenuId());
		
		// Set status and update deliver time
		entity.setDeliveredDate(new Timestamp(System.currentTimeMillis()));
		entity.setStatus("delivered");
		menuOrderRepository.saveOrUpdate(entity);
		
		LOGGER.info("Fetch pending order success");
	}
}
