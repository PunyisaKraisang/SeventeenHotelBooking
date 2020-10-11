package com.spring.dao;

import java.util.List;

import com.spring.dto.MenuOrderItemInfo;
import com.spring.entity.MenuOrderEntity;

public interface MenuOrderRepository {
	
	void save(MenuOrderEntity menuOrder);
	
	List<MenuOrderItemInfo> fetchPendingOrder();
}
