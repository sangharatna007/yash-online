package com.yash.exception;

public class CategoryNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3680663592725095136L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CategoryNotFoundException(String message) {
		super(message);
	}
}
