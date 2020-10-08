package com.spring.service;

import com.spring.entity.AdminEntity;

import java.util.List;

public interface AdminLoginService {
    public List<AdminEntity> fetch();
    public boolean getAdmin(String username, String password);
    public void addAdmin(AdminEntity admin);
    public void updateAdmin(AdminEntity admin);
    public void deleteAdmin(AdminEntity admin);
}
