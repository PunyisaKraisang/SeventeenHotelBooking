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
    public List<AdminEntity> fetch() {
        return adminLoginDAO.getAllAdmins();
    }

    @Override
    @Transactional
    public void addAdmin(AdminEntity admin) {
        adminLoginDAO.save(admin);
    }

    @Override
    @Transactional
    public void updateAdmin(AdminEntity admin) {
        adminLoginDAO.update(admin);
    }

    @Override
    @Transactional
    public void deleteAdmin(AdminEntity admin) {
        adminLoginDAO.delete(admin);
    }
}
