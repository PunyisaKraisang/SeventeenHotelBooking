package com.spring.dao;

import java.util.List;

import com.spring.dto.MenuOrderItemInfo;
import com.spring.entity.MenuOrderEntity;
import com.spring.entity.MenuOrderItemEntity;

public interface MenuOrderRepository {
	
	void save(MenuOrderEntity menuOrder);
	
	List<MenuOrderItemInfo> fetchPendingOrder();

	MenuOrderItemEntity loadOrderItem(int orderId, int menuId);
	
	void saveOrUpdate(MenuOrderItemEntity menuOrderItem);
}
