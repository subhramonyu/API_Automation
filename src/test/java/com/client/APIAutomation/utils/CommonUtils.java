package com.client.APIAutomation.utils;

import org.testng.Assert;

import io.qameta.allure.Step;
import io.restassured.response.Response;

/**
 * This Class contains all the common utility to support the Test Framework
 * Contains all the reusable methods
 * 
 * @author subhra.das
 *
 */
public class CommonUtils {

	public static String getCurrentDirectory() {
		return System.getProperty("user.dir");
	}

	@Step("Verifying the Response code :{0}")
	public static void verifyResponseCode(int responseCode, Response response) {

		Assert.assertTrue(response.getStatusCode() == responseCode, "Response status code is Not matched,Actual is: "
				+ response.getStatusCode() + "and expected is :" + responseCode);
	}
	
	@Step("Waiting for......:{0} min")
	public static void wait(int timeinMin) {
		try {
			Thread.sleep(timeinMin*60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
