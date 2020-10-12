package com.spring.service;

import com.spring.entity.AdminEntity;

import java.util.List;

public interface AdminLoginService extends AdminService<AdminEntity> {
    boolean getAdmin(String username, String password);
    //void updateAdmin(AdminEntity admin);
}
