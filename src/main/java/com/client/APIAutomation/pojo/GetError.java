package com.client.APIAutomation.pojo;

import java.io.Serializable;
import java.util.List;

public class GetError implements Serializable{

	private String reeiptHandle;
	private errorPayload errorPayload;
	
	public String getReeiptHandle() {
		return reeiptHandle;
	}
	public void setReeiptHandle(String reeiptHandle) {
		this.reeiptHandle = reeiptHandle;
	}
	public errorPayload getErrorPayload() {
		return errorPayload;
	}
	public void setErrorPayload(errorPayload errorPayload) {
		this.errorPayload = errorPayload;
	}
	
	
	
	
	
}
