package com.mvc.model;
public enum ApiResponseResult {
	SUCEESS("����"),
	FAIL("����");
	
	public final String message;
	
	ApiResponseResult(String message) {
		this.message = message;
	}
	
	public String getId() {
		return this.name();
	}
	
	public String getText() {
		return this.message;
	}
}
