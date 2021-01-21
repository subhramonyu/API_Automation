package com.client.APIAutomation.pojo;

import com.client.APIAutomation.pojo.MetaDataRequest;

public class ReportResponse {

	private MetaDataRequest metadata;

	private String exceptionCause;

	private GuardianResponse GuardianResponse;

	public MetaDataRequest getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaDataRequest metadata) {
		this.metadata = metadata;
	}

	public String getExceptionCause() {
		return exceptionCause;
	}

	public void setExceptionCause(String exceptionCause) {
		this.exceptionCause = exceptionCause;
	}

	public GuardianResponse getGuardianResponse() {
		return GuardianResponse;
	}

	public void setGuardianResponse(GuardianResponse GuardianResponse) {
		this.GuardianResponse = GuardianResponse;
	}

	@Override
	public String toString() {
		return "ClassPojo [metadata = " + metadata + ", exceptionCause = " + exceptionCause + ", GuardianResponse = "
				+ GuardianResponse + "]";
	}
}
