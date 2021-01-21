package com.client.APIAutomation.BatchPush;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.client.APIAutomation.core.Log;
import com.client.APIAutomation.pojo.GetError;
import com.client.APIAutomation.pojo.GetReport;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.qameta.allure.Step;

public class ReportBatchPush {
	

	private static ArrayList<GetReport> reportList ;
	private static GetReport report ;
	
	static {
		reportList = new ArrayList<GetReport>();
		report = new GetReport();
	}

	@Step("Pulling messages from report queues as a List : {0}")
	@SuppressWarnings("unchecked")
	public static List<GetReport> getReportResponseAsList(String responseString ) {
		try {
			reportList = new ObjectMapper().readValue(responseString, reportList.getClass());
		} catch (JsonParseException e) {
			Log.info("There is error in JSON parsing");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			Log.info("Empty JSON response");
			e.printStackTrace();
		}
		return reportList;
	}
	
	@Step("Pulling messages from report queues : {0}")
	public static GetReport  getReportResponse(String responseString) {
		try {
			report = new ObjectMapper().readValue(responseString, GetReport.class );
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return report;
	}
	
	@Step("verify that all messages has been pushed from report queue:{0}")
	public static void verifyEmptyReportQueue(List<?> message) {
		try {
			Assert.assertEquals(message.size(), 0, "All the messages from the report Queue has not been pushed");
		} catch (Exception e) {

		}

	}
}
