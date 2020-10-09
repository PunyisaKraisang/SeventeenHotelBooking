package com.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuKeywordListModel implements Serializable {

	private static final long serialVersionUID = 1093962050820552418L;
	
	private List<MenuKeywordModel> ethnicKeywords;
	private List<MenuKeywordModel> dietaryKeywords;
	
	public MenuKeywordListModel() {
		this.ethnicKeywords = new ArrayList<MenuKeywordModel>();
		this.dietaryKeywords = new ArrayList<MenuKeywordModel>();
	}

	public List<MenuKeywordModel> getEthnicKeywords() {
		return ethnicKeywords;
	}
	
	public void setEthnicKeywords(List<MenuKeywordModel> ethnicKeywords) {
		this.ethnicKeywords = ethnicKeywords;
	}
	
	public List<MenuKeywordModel> getDietaryKeywords() {
		return dietaryKeywords;
	}
	
	public void setDietaryKeywords(List<MenuKeywordModel> dietaryKeywords) {
		this.dietaryKeywords = dietaryKeywords;
	}
	
}
