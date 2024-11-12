package com.app.order.exception;

public class ErrorResponse {

	private String errorId;
	private String errorMessage;
	private String errorCode;
	
	
	public ErrorResponse(String errorId, String errorMessage, String errorCode) {
		super();
		this.errorId = errorId;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}


	public ErrorResponse() {
		super();
	}


	public String getErrorId() {
		return errorId;
	}


	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
