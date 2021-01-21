package com.client.APIAutomation.pojo;

public class Errors {

	private int http_status;
	private String message;
	private String details;
	private int error_code;
	private int[] data;
	
	
	public int getHttp_status() {
		return http_status;
	}
	public void setHttp_status(int http_status) {
		this.http_status = http_status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public int[] getData() {
		return data;
	}
	public void setData(int[] data) {
		this.data = data;
	}
}
