package com.spring.dao;

import com.spring.entity.AdminEntity;

import java.util.List;

public interface AdminLoginDAO extends AdminDAO<AdminEntity> {
    boolean getAdmin(String username, String password);
}
