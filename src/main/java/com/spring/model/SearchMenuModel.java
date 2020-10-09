package com.spring.model;

import java.io.Serializable;

public class SearchMenuModel implements Serializable {

	private static final long serialVersionUID = -7655770446998967187L;

	private String name;
	private boolean isRecommended;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	@Override
	public String toString() {
		return "SearchMenuModel [" + (name != null ? "name=" + name + ", " : "") + "isRecommended=" + isRecommended
				+ "]";
	}
	
	
}
