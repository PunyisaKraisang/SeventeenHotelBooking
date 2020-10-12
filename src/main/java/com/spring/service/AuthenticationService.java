package com.spring.service;

import com.spring.model.AccountModel;
import com.spring.model.LoginModel;

public interface AuthenticationService {

	AccountModel login(LoginModel loginModel);
}
