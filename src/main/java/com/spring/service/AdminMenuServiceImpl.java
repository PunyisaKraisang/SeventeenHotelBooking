package com.spring.service;

import com.spring.dao.AdminDAO;
import com.spring.dao.AdminMenuDAO;
import com.spring.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminMenuServiceImpl implements AdminService<MenuEntity> {
    @Autowired
    AdminDAO<MenuEntity> adminDAO;

    @Override
    @Transactional
    public List<MenuEntity> fetchAll() {
        return adminDAO.fetchAll();
    }

    @Override
    @Transactional
    public void saveNewEntity(MenuEntity food) {
        adminDAO.saveNewEntity(food);
    }

    @Override @Transactional
    public void deleteEntity(int menuId) { adminDAO.deleteEntity(menuId); }

    @Override @Transactional
    public MenuEntity getById(int menuId) { return adminDAO.getById(menuId); }

    @Override @Transactional
    public void updateExistEntity(MenuEntity food) { adminDAO.updateExistEntity(food); }
}
