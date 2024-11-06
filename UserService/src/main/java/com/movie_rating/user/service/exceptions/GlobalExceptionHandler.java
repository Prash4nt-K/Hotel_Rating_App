package com.movie_rating.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.movie_rating.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
		String message = resourceNotFoundException.getMessage();
		ApiResponse response = ApiResponse.builder().message(message).success(true).build();
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND); 
	}
	
}
