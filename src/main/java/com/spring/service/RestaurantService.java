package com.spring.service;

import java.util.List;

import com.spring.model.MenuModel;

public interface RestaurantService {
	
	List<MenuModel> fetchMenu();
}
