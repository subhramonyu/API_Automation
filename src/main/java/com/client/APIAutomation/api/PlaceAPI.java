package com.client.APIAutomation.api;

public enum PlaceAPI {

	BASEURL("https://reqres.in/api"), 
	ADD_ENDPOINT("/users");

	private String Attribute;

	PlaceAPI(String Attribute) {
		this.Attribute = Attribute;
	}

	public String getAttribute() {
		return Attribute;
	}
}
