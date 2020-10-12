package com.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity {

	@Id
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	@OneToOne(mappedBy = "account")
	@JoinColumn(name = "customer_id", unique = true)
	@MapsId
	private CustomerEntity customer;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
}
