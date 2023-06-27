package com.vnhPractical.crudOperation.response;

import org.springframework.http.HttpStatus;

public class CommonResponse {

	public Object response;
	public String responseMessage;
	public HttpStatus status;

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
