package com.spring.model;


public class AccountModel {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AccountModel [" + (username != null ? "username=" + username : "") + "]";
	}
	
	
}
