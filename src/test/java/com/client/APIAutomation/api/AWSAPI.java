package com.client.APIAutomation.api;

public enum AWSAPI {

	BASEURL("https://eij2sdxvtf.execute-api.us-east-1.amazonaws.com"), 
	NOTIFY_ENDPOINT("/dev/notify"), FAP("");

	private String Attribute;

	AWSAPI(String Attribute) {
		this.Attribute = Attribute;
	}

	public String getAttribute() {
		return Attribute;
	}
}
