package com.client.APIAutomation.FAPTests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.client.APIAutomation.FAP.FAP;
import com.client.APIAutomation.api.AWSAPI;
import com.client.APIAutomation.api.ContentType;
import com.client.APIAutomation.core.Log;
import com.client.APIAutomation.pojo.FAPErrorResponse;
import com.client.APIAutomation.restclient.GetAdapter;
import com.client.APIAutomation.restclient.RestAdapter;
import com.client.APIAutomation.utils.CommonUtils;
import com.client.APIAutomation.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;

@Feature("FAP")
@Epic("PS-193734:Productized Find a Provider (Global Logic)")
public class FAPTest {

	private RestAdapter request;
	private Response response;

	@BeforeTest(groups = { Constants.TEST, Constants.FAP }, description = "Initializing the Test")
	public void init() throws IOException {
		
	}

	
	
	@Story("PS -193815:GET API endpoint creation to consume FAP request from benefit system")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("14072")
	@Parameters({ "carrier_code", "zip_code", "distance", "plan_code", "plan_type" ,"provider_name", "office_name", "accepting_new", "in_network", "specialties" })
	@Description("PreRequisite : None")
	@Test(priority = 40, groups = { Constants.TEST,
			Constants.FAP }, description = "Validate Get API End point for FAP request")
	public void verifyGetFAPEndPoint(int carrier_code, int zip_code, int distance, String plan_code,
			String plan_type,String provider_name, String office_name, boolean accepting_new, boolean in_network,
			String specialties) throws InterruptedException {

		
		Log.info("Creating request object");
		request = GetAdapter.builder().setContentType(ContentType.JSON)
					.setBaseURL(AWSAPI.FAP.getAttribute()).setEndPoint("").build();

		HashMap<String, Object> queryParam = new HashMap<String,Object>();
		queryParam.put("carrier_code", carrier_code);
		queryParam.put("zip_code", zip_code);
		queryParam.put("distance",distance );
		queryParam.put("plan_code", plan_code);
		queryParam.put("plan_type", plan_type);
		queryParam.put("provider_name", provider_name);
		queryParam.put("office_name", office_name);
		queryParam.put("accepting_new",accepting_new );
		queryParam.put("in_network", in_network);
		queryParam.put("specialties", specialties);
		
		
		Log.info("Executing the Get request from FAP Get end point");
		response = request.execute(queryParam);
		
		Log.info("Verifying the  response code");
		CommonUtils.verifyResponseCode(200, response);
		
		
	}
	
	@Story("PS -193816:FAP request basic validations")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("14071")
	@Parameters({ "carrier_code", "zip_code", "distance", "plan_code", "plan_type" ,"provider_name", "office_name", "accepting_new", "in_network", "specialties" })
	@Description("PreRequisite : None")
	@Test(priority = 41, groups = { Constants.TEST,
			Constants.FAP }, description = "FAP request mandatory field validations")
	public void verifyGetFAPEndPointMandatoryFields(int carrier_code, int zip_code, int distance, String plan_code,
			String plan_type,String provider_name, String office_name, boolean accepting_new, boolean in_network,
			String specialties) throws InterruptedException {

		
		Log.info("Creating request object");
		request = GetAdapter.builder().setContentType(ContentType.JSON)
					.setBaseURL(AWSAPI.FAP.getAttribute()).setEndPoint("").build();

		HashMap<String, Object> queryParam = new HashMap<String,Object>();
		queryParam.put("carrier_code", "");
		queryParam.put("zip_code", zip_code);
		queryParam.put("distance",distance );
		queryParam.put("plan_code", plan_code);
		queryParam.put("plan_type", plan_type);
		queryParam.put("provider_name", provider_name);
		queryParam.put("office_name", office_name);
		queryParam.put("accepting_new",accepting_new );
		queryParam.put("in_network", in_network);
		queryParam.put("specialties", specialties);
		
		
		Log.info("Executing the Get request ");
		response = request.execute(queryParam);
		
		Log.info("Verifying the  response code");
		CommonUtils.verifyResponseCode(400, response);
		
		Log.info("Verifying the  Error Message");
		FAP.verifyErrorMessage(response.as(FAPErrorResponse.class).getMessage());
		
		
	}

	
	
	@Story("PS -193821:FAP request parameters mapping for collecting and deriving the carrier invocation flow")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("14073")
	@Parameters({ "carrier_code", "zip_code", "distance", "plan_code", "plan_type" ,"provider_name", "office_name", "accepting_new", "in_network", "specialties" })
	@Description("PreRequisite : None")
	@Test(priority = 42, groups = { Constants.TEST,
			Constants.FAP }, description = "FAP request all query param mapping and validations")
	public void verifyGetFAPEndPointAllFieldsValidation(int carrier_code, int zip_code, int distance, String plan_code,
			String plan_type,String provider_name, String office_name, boolean accepting_new, boolean in_network,
			String specialties) throws InterruptedException {

		
		Log.info("Creating request object");
		request = GetAdapter.builder().setContentType(ContentType.JSON)
					.setBaseURL(AWSAPI.FAP.getAttribute()).setEndPoint("").build();

		HashMap<String, Object> queryParam = new HashMap<String,Object>();
		queryParam.put("carrier_code", carrier_code);
		queryParam.put("zip_code", zip_code);
		queryParam.put("distance",distance );
		queryParam.put("plan_code", plan_code);
		queryParam.put("plan_type", plan_type);
		queryParam.put("provider_name", provider_name);
		queryParam.put("office_name", office_name);
		queryParam.put("accepting_new",accepting_new );
		queryParam.put("in_network", in_network);
		queryParam.put("specialties", specialties);
		
		
		Log.info("Executing the Get request ");
		response = request.execute(queryParam);
		
		Log.info("Verifying the  response code");
		CommonUtils.verifyResponseCode(200, response);
		
		
		
		
	}

	
	
	
	

}