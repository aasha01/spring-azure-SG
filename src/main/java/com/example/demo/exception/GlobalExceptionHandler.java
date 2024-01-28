package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    	Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(ProductPackageAlreadyExistingException.class)
	public ResponseEntity<String> packageAlreadyExistingException(ProductPackageAlreadyExistingException ex, WebRequest request) {
		String errorMessage = ex.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
    
    @ExceptionHandler(ProductPackageNotFoundException.class)
	public ResponseEntity<String> packageNotFoundException(ProductPackageNotFoundException ex, WebRequest request) {
		String errorMessage = ex.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
