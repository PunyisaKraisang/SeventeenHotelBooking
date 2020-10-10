package com.spring.model;

import java.io.Serializable;

public class SearchMenuModel implements Serializable {

	private static final long serialVersionUID = -7655770446998967187L;

	private String name;
	private String ethnic;
	private String dietary;
	private int min;
	private int max;
	private boolean isRecommended;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getDietary() {
		return dietary;
	}

	public void setDietary(String dietary) {
		this.dietary = dietary;
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	@Override
	public String toString() {
		return "SearchMenuModel [" + (name != null ? "name=" + name + ", " : "")
				+ (ethnic != null ? "ethnic=" + ethnic + ", " : "")
				+ (dietary != null ? "dietary=" + dietary + ", " : "") + "min=" + min + ", max="
				+ max + ", isRecommended=" + isRecommended + "]";
	}

}
