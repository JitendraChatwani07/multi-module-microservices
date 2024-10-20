package com.sarvika.technologies.assignment.exception;


public class ProductNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2445144649732574960L;

	public ProductNotFoundException(String message) {
        super(message);
    }
}
