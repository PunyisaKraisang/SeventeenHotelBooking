package com.spring.dao;

import com.spring.entity.AdminEntity;

import java.util.List;

public interface AdminLoginDAO {
    public boolean getAdmin(String username, String password);
    public List<AdminEntity> getAllAdmins();
    public void save(AdminEntity admin);
    public void delete(AdminEntity admin);
    public void update(AdminEntity admin);
}
