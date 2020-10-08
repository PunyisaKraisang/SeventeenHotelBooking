package com.spring.model;

import java.io.Serializable;

public class SearchMenuModel implements Serializable {

	private static final long serialVersionUID = -7655770446998967187L;

	private boolean isRecommended;

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}
	
	public boolean hasValue() {
		return isRecommended;
	}

	@Override
	public String toString() {
		return "SearchMenuModel [isRecommended=" + isRecommended + "]";
	}
	
	
}
