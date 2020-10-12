package com.spring.model;


public class AccountModel {
	
	private int customerId;
	private String username;

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

	@Override
	public String toString() {
		return "AccountModel [customerId=" + customerId + ", " + (username != null ? "username=" + username : "") + "]";
	}
	
	
}
