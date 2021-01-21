package com.client.APIAutomation.FAP;

import org.testng.Assert;

import com.client.APIAutomation.pojo.FAPErrorResponse;

import io.qameta.allure.Step;

/**
 * Validation related to FAP
 * @author subhra.das
 *
 */
public class FAP {
	
	
	private static FAPErrorResponse response ;
	
	
	
	@Step("verify that all messages has been pushed from Anomaly bucket:{0}")
	public static void verifyErrorMessage(String message) {
		Assert.assertEquals(message, "Invalid Request","Message is not matching");
	}
}
