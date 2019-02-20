package com.yash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.yash.utils.Constants;

@ControllerAdvice
public class ExceptionHandle {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity categoryNotFoundException() {
		return new ResponseEntity(Constants.CATEGORY_NOT_FOUND, HttpStatus.NOT_FOUND);
	}

	/*
	 * @SuppressWarnings({ "rawtypes", "unchecked" })
	 * 
	 * @ExceptionHandler(Exception.class) public ResponseEntity genericException() {
	 * return new ResponseEntity(Constants.SOMETHING_WENT_WRONG,
	 * HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

}
