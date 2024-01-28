package com.example.demo.exception;

public class ProductPackageAlreadyExistingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductPackageAlreadyExistingException(String errorMessage) {
	    super(errorMessage);
	}

}
