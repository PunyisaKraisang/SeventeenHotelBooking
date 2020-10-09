package com.spring.dao;

import java.util.Set;

import com.spring.dto.SearchMenu;
import com.spring.entity.MenuEntity;

public interface MenuRepository {

	Set<MenuEntity> fetch(SearchMenu searchMenu);
}
