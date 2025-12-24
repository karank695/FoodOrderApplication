package com.food.foodorderapplication.entities;

public class Response {

	private String message;
	private String timeStamp;
	private String responseCode;
	private String data;
	public Response() {};
	public Response(String message, String timeStamp, String responseCode, String data) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
		this.responseCode = responseCode;
	}
	
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
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
}
