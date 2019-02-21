package com.yash.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(NoDataException.class)
	public ResponseEntity dataNotFoundException() {
		return new ResponseEntity("No Data Found", HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(NoDataByIdException.class)
	public ResponseEntity dataNotFoundByIdException() {
		return new ResponseEntity("No Data Found for mentioned input", HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(Exception.class)
	public ResponseEntity genericException() {
		return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}