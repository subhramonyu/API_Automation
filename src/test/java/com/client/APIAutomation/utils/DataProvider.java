package com.client.APIAutomation.utils;

/**
 * For generating the test related data dynamically
 * @author subhra.das
 *
 */

public class DataProvider extends Config{
	
	
	
	public  String getData(MetaData data) {
		String value = "";
		switch (data) {
		case GoodGUID:
			value = getGUID(IsSuccess.YES);
			break;
		case BadGUID:
			value = getGUID(IsSuccess.NO);
			break;
		case carrierLookup:
			value = "guardianinsurance";
			break;
		case eventType:
			value = "enroll";
			break;
		case orgID:
			value = String.valueOf(RandomUtils.getRandomNumber(1000));
			break;
		case sizeOfOrg:
			value= String.valueOf(RandomUtils.getRandomNumber(18));
			break;
		case anomaly:
			value ="false";
			break;

		default:
			break;
		}
		return value;

	}
	
	
}
