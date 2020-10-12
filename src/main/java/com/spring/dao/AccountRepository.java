package com.spring.dao;

import com.spring.entity.AccountEntity;
import com.spring.model.LoginModel;

public interface AccountRepository {

	AccountEntity get(LoginModel login);
}
