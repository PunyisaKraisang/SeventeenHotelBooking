package com.spring.dao;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.AccountEntity;
import com.spring.model.LoginModel;

@Transactional
@Repository
public class AccountRepositoryImpl extends BaseRepository implements AccountRepository {

	private static final Logger LOGGER = Logger.getLogger(AccountRepositoryImpl.class);
	
	public AccountEntity get(LoginModel login) {
		LOGGER.info("Load account");
		
		// Get account by username
		AccountEntity persistedAccount = getSession().get(AccountEntity.class, login.getUsername());
		
		System.out.println(persistedAccount);
		System.out.println(login);
		
		if (persistedAccount == null) {
			LOGGER.info("Username doese not exist");
			return null;
		}
		
		if (persistedAccount.getPassword() != login.getPassword()) {
			LOGGER.info("Password doesn not match");
			return null;
		}
		
		LOGGER.info("Load account success");
		return persistedAccount;
		
	}

}
