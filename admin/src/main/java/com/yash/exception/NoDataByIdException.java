package com.yash.exception;

public class NoDataByIdException extends RuntimeException{

	private static final long serialVersionUID = -3680663592725095136L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NoDataByIdException(String message) {
	    super();
	}
}