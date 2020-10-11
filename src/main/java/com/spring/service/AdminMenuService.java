package com.spring.service;

import com.spring.entity.MenuEntity;

import java.util.List;

public interface AdminMenuService {
    public List<MenuEntity> listAllFoods();
    public void saveUpdateFood(MenuEntity food);
    public void deleteFood(int menuId);
}
