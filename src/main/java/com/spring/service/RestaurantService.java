package com.spring.service;

import java.util.List;

import com.spring.model.MenuModel;
import com.spring.model.SearchMenuModel;

public interface RestaurantService {
	
	List<MenuModel> fetchMenu(SearchMenuModel searchModel);
}
