package com.spring.dto;

public class SearchMenu {

	private String name;
	private int ethnicId;
	private int dietaryId;
	private int min;
	private int max;
	private boolean isRecommended;

	public SearchMenu(String name, int ethnicId, int dietaryId, int min, int max, boolean isRecommended) {
		this.name = name;
		this.ethnicId = ethnicId;
		this.dietaryId = dietaryId;
		this.min = min;
		this.max = max;
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

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
	
	public boolean isRecommended() {
		return isRecommended;
	}
	
}
