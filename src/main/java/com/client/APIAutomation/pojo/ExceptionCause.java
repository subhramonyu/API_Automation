package com.client.APIAutomation.pojo;

import java.util.List;

public class ExceptionCause {

	private String status;
	private List<Errors> errors;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Errors> getErrors() {
		return errors;
	}

	public void setErrors(List<Errors> errors) {
		this.errors = errors;
	}

}
