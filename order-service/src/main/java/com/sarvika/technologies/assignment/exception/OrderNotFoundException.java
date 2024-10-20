package com.sarvika.technologies.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OrderNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 7317132811705224267L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
