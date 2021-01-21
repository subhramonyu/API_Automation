package com.client.APIAutomation.Boost;

import org.testng.Assert;

import io.qameta.allure.Step;

/**
 * create enrollment related validations
 * 
 * @author subhra.das
 *
 */
public class EnrollmentFlow {

	@Step("Verifying the  Guid :{0}")
	public static void verifyGuid(String ActualGuid, String ExpectedGuid) {
		Assert.assertTrue(ActualGuid.contentEquals(ExpectedGuid), "Actual Guid is not matching with the Expected Guid");
	}

	@Step("Verifying the  Carrier Look up :{0}")
	public static void verifyCarrierLookUp(String ActualValue, String ExpectedValue) {
		Assert.assertTrue(ActualValue.contentEquals(ExpectedValue),
				"Actual Carrier Look up is not matching with the Expected Carrier Look up");
	}

	@Step("Verifying the  Event Type :{0}")
	public static void verifyEventType(String ActualValue, String ExpectedValue) {
		Assert.assertTrue(ActualValue.contentEquals(ExpectedValue),
				"Actual Event type is not matching with the Expected Event type");
	}

	@Step("Verifying the Org Id :{0}")
	public static void verifyOrgId(int ActualValue, int ExpectedValue) {
		Assert.assertTrue(ActualValue == ExpectedValue, "Actual Org Id is not matching with the Expected Org Id");
	}

	@Step("Verifying the Size of Org :{0}")
	public static void verifySizeOfOrg(int ActualValue, int ExpectedValue) {
		Assert.assertTrue(ActualValue == ExpectedValue, "Actual Org Id is not matching with the Expected Org Id");
	}

	@Step("Verifying the Is Recieved Value :{0}")
	public static void verifyIsRecieved(boolean value) {
		Assert.assertTrue(!value, "IsRecieved value is not matching and found :" + value);
	}

	@Step("Verifying the Message :{0}")
	public static void verifyMessage(String ActualValue, String ExpectedValue) {
		Assert.assertTrue(ActualValue.contentEquals(ExpectedValue),
				"Actual Message is not matching with the Expected Message");
	}

	@Step("Verifying the Is Error value :{0}")
	public static void verifyIsError(boolean value) {
		Assert.assertFalse(value, "IsError value is not matching and found :" + value);
	}

	@Step("Verifying the Is Anomaly value :{0}")
	public static void verifyIsAnomaly(boolean value) {
		Assert.assertFalse(value, "IsAnomaly value is not matching and found :" + value);
	}

}
