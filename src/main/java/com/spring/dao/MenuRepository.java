package com.spring.dao;

import java.util.List;

import com.spring.entity.MenuEntity;

public interface MenuRepository {

	List<MenuEntity> fetch();
}
