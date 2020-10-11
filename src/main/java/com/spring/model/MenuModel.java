package com.spring.model;

import java.io.Serializable;
import java.util.Set;

public class MenuModel implements Serializable {

	private static final long serialVersionUID = -4823787907969672128L;
	
	private int menuId;
	private String name;
	private double price;
	private String description;
	private boolean recommended;
	private Set<MenuKeywordModel> keywords;
	
	public int getMenuId() {
		return menuId;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isRecommended() {
		return recommended;
	}
	
	public void setRecommended(boolean isRecommended) {
		this.recommended = isRecommended;
	}

	public Set<MenuKeywordModel> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<MenuKeywordModel> keywords) {
		this.keywords = keywords;
	}
	
	
}
