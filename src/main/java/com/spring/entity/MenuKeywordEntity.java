package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_keyword")
public class
MenuKeywordEntity {

	@Id
	@Column(name = "keyword_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int keywordId;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "category")
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
