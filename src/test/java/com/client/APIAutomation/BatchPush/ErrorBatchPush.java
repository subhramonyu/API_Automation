package com.client.APIAutomation.BatchPush;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.client.APIAutomation.pojo.GetError;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.qameta.allure.Step;

/**
 * Validation related to error batch push 
 * @author subhra.das
 *
 */
public class ErrorBatchPush {

	private static ArrayList<GetError> errorList;
	private static GetError error;

	static {
		errorList = new ArrayList<GetError>();
		error = new GetError();
	}

	@Step("Get Error message as a List :{0}")
	@SuppressWarnings("unchecked")
	public static List<GetError> getErrorResponseAsList(String responseString) {
		try {
			errorList = new ObjectMapper().readValue(responseString, errorList.getClass());
		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return errorList;
	}

	@Step("Get Error message as String:{0}")
	public static GetError getErrorResponse(String responseString) {
		try {
			error = new ObjectMapper().readValue(responseString, GetError.class);
		} catch (JsonParseException e) {

			e.printStackTrace();
		} catch (JsonMappingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return error;
	}

	@Step("verify that all messages has been pushed from Error queue:{0}")
	public static void verifyEmptyErrorQueue(List<?> message) {
		try {
			Assert.assertEquals(message.size(), 0, "All the messages from the error Queue has not been pushed");
		} catch (NullPointerException e) {
		}

	}
}
