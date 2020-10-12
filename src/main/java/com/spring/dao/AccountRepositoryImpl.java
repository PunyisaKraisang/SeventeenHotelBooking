package com.spring.dao;


import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.AccountEntity;
import com.spring.entity.MenuOrderItemEntity;
import com.spring.model.LoginModel;

@Transactional
@Repository
public class AccountRepositoryImpl extends BaseRepository implements AccountRepository {

	private static final Logger LOGGER = Logger.getLogger(AccountRepositoryImpl.class);
	
	public AccountEntity get(LoginModel login) {
		LOGGER.info("Get account");
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<AccountEntity> query = builder.createQuery(AccountEntity.class);
		Root<AccountEntity> root = query.from(AccountEntity.class);
		
		// Add criteria by order ID and menu ID 
		Predicate andClause =  builder.and(
				builder.equal(root.get("username"), login.getUsername()), 
				builder.equal(root.get("password"), login.getPassword()));
		
		query.select(root).where(andClause);
		
		try {
			// Fetch result
			AccountEntity result = getSession().createQuery(query).getSingleResult();
			LOGGER.info("Get success");
			return result;
			
		} catch (NoResultException e) {
			LOGGER.error("Username or password doesn't match");
			return null;
		}
		
	}

}
