package com.spring.dto;

public enum KeywordCategory {
	ETHNIC("ethnic"), STYLE("style"), DIETARY("dietary"), MEAT("meat"), DISH("dish");
	
	public final String code;
	
	private KeywordCategory(String code) {
		this.code = code;
	}
}
