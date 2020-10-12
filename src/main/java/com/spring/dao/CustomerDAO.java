package com.spring.dao;

import com.spring.entity.AccountEntity;
import com.spring.entity.CustomerEntity;

import java.util.Map;

public interface CustomerDAO {
    void newSignUp(Map<String, Object> params);
    void saveAcc(AccountEntity acc);
}
