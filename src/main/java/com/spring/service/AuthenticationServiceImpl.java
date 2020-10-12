package com.spring.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.AccountRepository;
import com.spring.entity.AccountEntity;
import com.spring.model.AccountModel;
import com.spring.model.LoginModel;
import com.spring.util.ModelUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationServiceImpl.class);
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
	public AccountModel login(LoginModel loginModel) {
		
		AccountEntity account = accountRepository.get(loginModel);
		
		if (account == null) {
			return null;
		}
		
		AccountModel model = ModelUtil.parse(account);
		
		LOGGER.info("Login success");
		return model;
	}

}
