package com.app.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OrderProcessingException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorResponse> handleOrderProcessingException(String message){
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(String.valueOf(501));
		errorResponse.setErrorMessage(message);
		errorResponse.setErrorId("ORD_01");
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(CustomerDetailsNotFound.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(String message){
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(String.valueOf(404));
		errorResponse.setErrorMessage(message);
		errorResponse.setErrorId("ORD_03");
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(OrderNumberNotUniqueException.class)
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	public ResponseEntity<ErrorResponse> handleOrderIdAlreadyExistException(String message){
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(String.valueOf(406));
		errorResponse.setErrorMessage(message);
		errorResponse.setErrorId("ORD_02");
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
		
	}

//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//	public ResponseEntity<ErrorResponse> handleGenericException(String message){
//		
//		ErrorResponse errorResponse = new ErrorResponse();
//		errorResponse.setErrorCode(String.valueOf(500));
//		errorResponse.setErrorMessage(message);
//		errorResponse.setErrorId("ORD_04");
//		
//		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
//		
//	}
//	
}
