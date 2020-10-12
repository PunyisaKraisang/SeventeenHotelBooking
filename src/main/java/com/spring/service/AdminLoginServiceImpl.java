package com.spring.service;

import com.spring.dao.AdminLoginDAO;
import com.spring.entity.AdminEntity;
import com.spring.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {
    @Autowired
    private AdminLoginDAO adminLoginDAO;

    @Override
    @Transactional
    public boolean getAdmin(String username, String password) {
        return adminLoginDAO.getAdmin(username, password);
    }

    @Override
    @Transactional
    public List<AdminEntity> fetchAll() {
        return adminLoginDAO.fetchAll();
    }

    @Override
    @Transactional
    public void saveNewEntity(AdminEntity admin) {
        adminLoginDAO.saveNewEntity(admin);
    }

    @Override
    @Transactional
    public void deleteEntity(int adminId) {
        adminLoginDAO.deleteEntity(adminId);
    }

    @Override @Transactional
    public AdminEntity getById(int id) { return adminLoginDAO.getById(id); }

    @Override @Transactional
    public void updateExistEntity(AdminEntity admin) { adminLoginDAO.updateExistEntity(admin); }
}
