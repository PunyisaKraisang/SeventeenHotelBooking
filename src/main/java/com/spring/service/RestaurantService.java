package com.spring.service;

import java.util.List;

import com.spring.dto.KeywordCategory;
import com.spring.model.MenuKeywordModel;
import com.spring.model.MenuModel;
import com.spring.model.SaveMenuOrderModel;
import com.spring.model.SearchMenuModel;

public interface RestaurantService {
	
	List<MenuModel> fetchMenu(SearchMenuModel searchModel);
	
	List<MenuKeywordModel> fetchMenuKeyword(KeywordCategory category);
	
	void makeOrder(String username, SaveMenuOrderModel orderModel);
}
