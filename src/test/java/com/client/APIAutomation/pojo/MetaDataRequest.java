package com.client.APIAutomation.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.qameta.allure.Step;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDataRequest {
	private String guid ;
	private String carrierLookup;
	private String eventType;
	private int orgID;
	private int sizeOfOrg;
	private boolean isAnomaly;
	
	
	
	
	public MetaDataRequest(){
	}

	public String getGuid() {
		return guid;
	}

	@Step("Setting the GUID : {1}")
	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getCarrierLookup() {
		return carrierLookup;
	}

	@Step("Setting the carrierLookup : {1}")
	public void setCarrierLookup(String carrierLookup) {
		this.carrierLookup = carrierLookup;
	}

	public String getEventType() {
		return eventType;
	}

	@Step("Setting the eventType : {1}")
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getOrgID() {
		return orgID;
	}

	@Step("Setting the orgID : {1}")
	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}

	public int getSizeOfOrg() {
		return sizeOfOrg;
	}

	@Step("Setting the sizeOfOrg : {1}")
	public void setSizeOfOrg(int sizeOfOrg) {
		this.sizeOfOrg = sizeOfOrg;
	}

	public boolean isAnomaly() {
		return isAnomaly;
	}

	public void setAnomaly(boolean isAnomaly) {
		this.isAnomaly = isAnomaly;
	}

	

	
	
	
}
