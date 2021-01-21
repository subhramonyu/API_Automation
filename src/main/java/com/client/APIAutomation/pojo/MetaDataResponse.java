package com.client.APIAutomation.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.qameta.allure.Step;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDataResponse {
	
	private String guid ;
	private String carrierLookup;
	private String eventType;
	private int orgID;
	private int sizeOfOrg;
	private boolean isReceived;
	private String message;
	private boolean isError;
	private boolean isAnomaly;
	
	
	
	public MetaDataResponse() {
	}

	@Step("Getting the GUID ")
	public String getGuid() {
		return guid;
	}

	
	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Step("Getting the CarrierLookUp ")
	public String getCarrierLookup() {
		return carrierLookup;
	}

	
	public void setCarrierLookup(String carrierLookup) {
		this.carrierLookup = carrierLookup;
	}

	@Step("Getting the EventType ")
	public String getEventType() {
		return eventType;
	}

	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Step("Getting the OrgId ")
	public int getOrgID() {
		return orgID;
	}

	
	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}

	@Step("Getting the SizeOfOrg ")
	public int getSizeOfOrg() {
		return sizeOfOrg;
	}

	
	public void setSizeOfOrg(int sizeOfOrg) {
		this.sizeOfOrg = sizeOfOrg;
	}

	@Step("Getting the Message ")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Step("Getting the IsError Flag value ")
	public boolean isError() {
		return isError;
	}

	public void setIsError(boolean isError) {
		this.isError = isError;
	}

	@Step("Getting the IsRecieved flag value ")
	public boolean isReceived() {
		return isReceived;
	}

	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}

	@Step("Getting the isAnomalyFalg value ")
	public boolean isAnomaly() {
		return isAnomaly;
	}

	public void setAnomaly(boolean isAnomaly) {
		this.isAnomaly = isAnomaly;
	}

	
	
	
}
