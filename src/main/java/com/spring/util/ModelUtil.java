package com.spring.util;

import com.spring.entity.MenuEntity;
import com.spring.model.MenuModel;

public final class ModelUtil {

	private ModelUtil() {
		
	}
	
	public static MenuModel parse(MenuEntity from) {
		MenuModel model = new MenuModel();
		model.setMenuId(from.getMenuId());
		model.setName(from.getName());
		model.setPrice(from.getPrice());
		model.setDescription(from.getDescription());
		model.setRecommended(from.isRecommended());
		return model;
	}
}
