package com.sarvika.technologies.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4863193166393942813L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
