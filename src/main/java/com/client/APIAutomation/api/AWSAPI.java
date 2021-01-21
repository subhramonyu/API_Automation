package com.client.APIAutomation.api;

/**
 * Enum for containing all the end points and base URL
 * @author subhra.das
 *
 */
public enum AWSAPI {

	BASEURL("http://boost-env-2-4-f01f4f9e1ad01872.elb.us-east-1.amazonaws.com"), 
	NOTIFY_ENDPOINT("/notify"),
	ERROR_ENDPOINT("/error"),
	REPORT_ENDPOINT("/report"),
	ANOMALY_ENDPOINT("/anomaly"),
	FAP("http://boost-env-2-4-f01f4f9e1ad01872.elb.us-east-1.amazonaws.com/provider");

	private String Attribute;

	AWSAPI(String Attribute) {
		this.Attribute = Attribute;
	}

	public String getAttribute() {
		return Attribute;
	}
}
