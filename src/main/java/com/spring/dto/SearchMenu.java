package com.spring.dto;

public class SearchMenu {

	private String name;
	private int ethnicId;
	private int dietaryId;
	private boolean isRecommended;

	public SearchMenu(String name, int ethnicId, int dietaryId, boolean isRecommended) {
		this.name = name;
		this.ethnicId = ethnicId;
		this.dietaryId = dietaryId;
		this.isRecommended = isRecommended;
	}

	public String getName() {
		return name;
	}
	
	public int getEthnicId() {
		return ethnicId;
	}

	public int getDietaryId() {
		return dietaryId;
	}
	
	public boolean isRecommended() {
		return isRecommended;
	}
	
}
