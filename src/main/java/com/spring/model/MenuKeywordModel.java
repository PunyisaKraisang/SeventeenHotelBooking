package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;

public class MenuKeywordModel implements Serializable {

	private static final long serialVersionUID = 3249598088198288929L;
	
	private int keywordId;
	private String value;
	private String category;
	
	public int getKeywordId() {
		return keywordId;
	}
	
	public void setKeywordId(int keywordId) {
		this.keywordId = keywordId;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

}
