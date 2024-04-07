package com.microservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.microservices.paylod.GenericAPIMessage;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<GenericAPIMessage> handler1(CustomException ex) {

		String message = ex.getMessage();

		GenericAPIMessage apiMessage = new GenericAPIMessage("exception occur", message, "500");

		return ResponseEntity.status(HttpStatus.OK).body(apiMessage);
	}

}
