package com.client.APIAutomation.pojo;

import com.client.APIAutomation.pojo.MetaDataRequest;

public class errorPayload {

	private String timestamp ;
	private String message ;
	private MetaDataRequest metadata ;
	private String exceptionMessage ;
	private ExceptionCause exceptionCause ;
	
	
	
	public String getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public ExceptionCause getExceptionCause() {
		return exceptionCause;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public void setExceptionCause(ExceptionCause exceptionCause) {
		this.exceptionCause = exceptionCause;
	}
	public MetaDataRequest getMetadata() {
		return metadata;
	}
	public void setMetadata(MetaDataRequest metadata) {
		this.metadata = metadata;
	}
	
}
