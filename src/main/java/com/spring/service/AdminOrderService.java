package com.spring.service;

import java.util.List;

import com.spring.dto.DeliverMenuOrderItem;
import com.spring.model.MenuOrderItemInfoModel;

public interface AdminOrderService {

	List<MenuOrderItemInfoModel> fetchPendingOrder();
	
	void deliverOrder(DeliverMenuOrderItem orderItem);
}
