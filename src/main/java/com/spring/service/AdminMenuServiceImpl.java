package com.spring.service;

import com.spring.dao.AdminMenuDAO;
import com.spring.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminMenuServiceImpl implements AdminMenuService {
    @Autowired
    AdminMenuDAO adminMenuDAO;

    @Override
    @Transactional
    public List<MenuEntity> listAllFoods() {
        return adminMenuDAO.listAllFoods();
    }
}
