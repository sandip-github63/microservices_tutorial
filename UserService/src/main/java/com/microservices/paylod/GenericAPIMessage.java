package com.microservices.paylod;

public class GenericAPIMessage {

	private String data;

	private String message;

	private String statusCode;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public GenericAPIMessage(String data, String message, String statusCode) {
		super();
		this.data = data;
		this.message = message;
		this.statusCode = statusCode;
	}

	public GenericAPIMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

}
