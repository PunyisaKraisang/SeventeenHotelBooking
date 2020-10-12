package com.spring.service;

import com.spring.dao.CustomerDAO;
import com.spring.entity.AccountEntity;
import com.spring.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override @Transactional
    public void newSignUp(Map<String, Object> params) {
        customerDAO.newSignUp(params);
    }

    public void saveAcc(AccountEntity acc) { customerDAO.saveAcc(acc);}
}
