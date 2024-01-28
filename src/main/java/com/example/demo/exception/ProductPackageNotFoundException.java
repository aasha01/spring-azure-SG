package com.example.demo.exception;

public class ProductPackageNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductPackageNotFoundException(String errorMessage) {
	    super(errorMessage);
	}

}
