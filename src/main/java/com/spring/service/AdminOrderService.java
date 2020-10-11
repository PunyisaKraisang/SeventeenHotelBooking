package com.spring.service;

import java.util.List;

import com.spring.model.MenuOrderItemInfoModel;

public interface AdminOrderService {

	List<MenuOrderItemInfoModel> fetchPendingOrder();
}
