package com.spring.dao;

import java.util.List;
import java.util.Set;

import com.spring.dto.KeywordCategory;
import com.spring.dto.SearchMenu;
import com.spring.entity.MenuEntity;
import com.spring.entity.MenuKeywordEntity;

public interface MenuRepository {

	Set<MenuEntity> fetch(SearchMenu searchMenu);
	
	List<MenuKeywordEntity> fetchKeyword(List<KeywordCategory> categories);
}
