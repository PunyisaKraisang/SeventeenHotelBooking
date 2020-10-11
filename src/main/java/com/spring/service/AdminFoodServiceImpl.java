package com.spring.service;

import com.spring.dao.AdminFoodDAO;
import com.spring.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminFoodServiceImpl implements AdminFoodService {
    @Autowired
    AdminFoodDAO adminFoodDAO;

    @Override
    @Transactional
    public void saveUpdateFood(MenuEntity food) {
        adminFoodDAO.saveUpdateFood(food);
    }
}
