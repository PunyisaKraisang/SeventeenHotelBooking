package com.spring.util;

import java.util.stream.Collectors;

import com.spring.dto.SearchMenu;
import com.spring.entity.MenuEntity;
import com.spring.entity.MenuKeywordEntity;
import com.spring.model.MenuKeywordModel;
import com.spring.model.MenuModel;
import com.spring.model.SearchMenuModel;

public final class ModelUtil {

	private ModelUtil() {
		
	}
	
	public static MenuModel parse(MenuEntity from) {
		MenuModel to = new MenuModel();
		to.setMenuId(from.getMenuId());
		to.setName(from.getName());
		to.setPrice(from.getPrice());
		to.setDescription(from.getDescription());
		to.setRecommended(from.isRecommended());
		to.setKeywords(from.getKeywords().stream().map((key) -> parse(key)).collect(Collectors.toSet()));
		return to;
	}

	public static MenuKeywordModel parse(MenuKeywordEntity from) {
		MenuKeywordModel to = new MenuKeywordModel();
		to.setKeywordId(from.getKeywordId());
		to.setValue(from.getValue());
		to.setCategory(from.getCategory());
		return to;
	}
	
	public static SearchMenu parse(SearchMenuModel from) {
		return new SearchMenu(from.getName(),
				(from.getEthnic() != null && !from.getEthnic().isEmpty()) ? Integer.parseInt(from.getEthnic()) : -1,
				(from.getDietary() != null && !from.getDietary().isEmpty()) ? Integer.parseInt(from.getDietary()) : -1,
				from.getMin(),
				from.getMax(),
				from.isRecommended());
	}
}
