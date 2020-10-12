package com.spring.dao;

import com.spring.entity.AccountEntity;
import com.spring.entity.CustomerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Map;

@Repository
@Transactional
public class CustomerDAOImpl extends BaseRepository implements CustomerDAO {
    @Override
    public void newSignUp(Map<String, Object> params) {
        String username = (String) params.get("username");
        System.out.println(username);
        AccountEntity account = new AccountEntity();
        account.setPassword((String)params.get("password"));
        account.setUsername((String)params.get("username"));
        CustomerEntity cust = new CustomerEntity();
        cust.setAccount(account);
        cust.setPhone((String)params.get("phone"));
        cust.setEmailAddress((String)params.get("emailAddress"));
        cust.setBirthDate(Date.valueOf((String)params.get("birthDate")));
        cust.setLastName((String)params.get("lastName"));
        cust.setFirstName((String)params.get("firstName"));
        cust.setUsername((String)params.get("username"));
        account.setCustomer(cust);
        getSession().saveOrUpdate(cust);
    }
    public void saveAcc(AccountEntity acc) {
        getSession().saveOrUpdate(acc);
    }
}
