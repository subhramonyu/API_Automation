package com.client.APIAutomation.BatchPush;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.client.APIAutomation.pojo.GetAnomaly;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.qameta.allure.Step;

/**
 * Validation related to Amonaly batch push
 * @author subhra.das
 *
 */

public class AnomalyBatchPush {
	
	private static ArrayList< GetAnomaly> anomalyList ;
	private static GetAnomaly anomaly ;
	
	static {
		anomalyList = new ArrayList<GetAnomaly>();
		anomaly = new GetAnomaly();
	}

	@Step("Get Anomaly message as a List from Amonaly bucket :{0}")
	@SuppressWarnings("unchecked")
	public static List<GetAnomaly> getAnomalyResponseAsList(String responseString ) {
		try {
			anomalyList = new ObjectMapper().readValue(responseString, anomalyList.getClass());
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return anomalyList;
	}
	
	@Step("Get Anomaly message as String : {0}")
	public static GetAnomaly  getAnomalyResponse(String responseString) {
		try {
			anomaly = new ObjectMapper().readValue(responseString, GetAnomaly.class );
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return anomaly;
	}
	
	@Step("verify that all messages has been pushed from Anomaly bucket:{0}")
	public static void verifyEmptyAnomalyBucket(List<?> message) {
		try {
			Assert.assertEquals(message.size(), 0, "All the messages from the error Queue has not been pushed");
		} catch (NullPointerException e) {

		}

	}
}
