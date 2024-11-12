package com.app.blogger.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	private String errorMessage;
	private String errorDescription;
	private String errorCode;
	private String errorId;
	private  LocalDateTime errorDate;
	
	
	public ErrorResponse(String errorMessage, String errorDescription, String errorCode, String errorId,
			 LocalDateTime errorDate) {
		super();
		this.errorMessage = errorMessage;
		this.errorDescription = errorDescription;
		this.errorCode = errorCode;
		this.errorId = errorId;
		this.errorDate = errorDate;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getErrorDescription() {
		return errorDescription;
	}


	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorId() {
		return errorId;
	}


	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}


	public LocalDateTime getErrorDate() {
		return errorDate;
	}


	public void setErrorDate(LocalDateTime errorDate) {
		this.errorDate = errorDate;
	}
	
	
	
	
}
