package com.food.foodorderapplication.globalExceptionHandlers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.food.foodorderapplication.entities.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Response rs = new Response();
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		rs.setMessage(errors.toString());
		rs.setResponseCode("400");
		rs.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Response> handleResourceNotFoundException(ResourceNotFoundException e) {
		Response rs = new Response();
		rs.setMessage(e.getMessage());
		rs.setResponseCode("400");
		rs.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Response> handleResourceNotFoundException(RuntimeException e) {
		Response rs = new Response();
		rs.setMessage(e.getMessage());
		rs.setResponseCode("400");
		rs.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	}

}
