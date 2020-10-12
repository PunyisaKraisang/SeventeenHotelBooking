package com.spring.service;

import com.spring.entity.AccountEntity;
import com.spring.entity.CustomerEntity;

import java.util.Map;

public interface CustomerService {
    void newSignUp(Map<String, Object> params);
    void saveAcc(AccountEntity acc);
}
