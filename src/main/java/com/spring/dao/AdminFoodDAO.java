package com.spring.dao;

import com.spring.entity.MenuEntity;

public interface AdminFoodDAO {
    public void saveUpdateFood(MenuEntity food);
    public void deleteFood(int menuId);
}
