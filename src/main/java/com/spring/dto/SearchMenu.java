package com.spring.dto;

public class SearchMenu {

	private String name;
	private boolean isRecommended;

	public SearchMenu(String name, boolean isRecommended) {
		this.name = name;
		this.isRecommended = isRecommended;
	}

	public String getName() {
		return name;
	}
	
	public boolean isRecommended() {
		return isRecommended;
	}
	
}
