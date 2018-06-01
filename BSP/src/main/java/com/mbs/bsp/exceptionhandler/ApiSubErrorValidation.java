package com.mbs.bsp.exceptionhandler;

public class ApiSubErrorValidation extends ApiSubError {
	
	private String object;
	private String field;
	private Object rejectedValue;
	private String message;
	
	ApiSubErrorValidation(String object, String message) {
		this.object = object;
		this.message = message;
	}
	
	
}
