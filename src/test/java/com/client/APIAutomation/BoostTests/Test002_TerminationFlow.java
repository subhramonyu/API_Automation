package com.client.APIAutomation.BoostTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.client.APIAutomation.api.AWSAPI;
import com.client.APIAutomation.core.AllureUtils;
import com.client.APIAutomation.core.Log;
import com.client.APIAutomation.pojo.MetaDataRequest;
import com.client.APIAutomation.pojo.MetaDataResponse;
import com.client.APIAutomation.restclient.ContentType;
import com.client.APIAutomation.restclient.PostAdapter;
import com.client.APIAutomation.restclient.RestAdapter;
import com.client.APIAutomation.utils.Config;
import com.client.APIAutomation.utils.Constants;
import com.client.APIAutomation.utils.PropertyUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Story("PS -192590:The validation failed requests should be returned as 400-Bad Request")
@Feature("TERMINATION FLOW")
public class Test002_TerminationFlow {
	private PropertyUtils Authtoken;
	private MetaDataResponse   response;

	@BeforeTest(groups = { Constants.TEST,Constants.Termination}, description = "Initializing the Test")
	public void init() throws IOException {
		Authtoken = PropertyUtils.create(Config.AddPlaceAPI);

	}
	
		
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("TC_001")
	@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : PlanSource Benefits System requests should be received by AWS API Gateway")
	@Test(groups = {
			Constants.Termination}, description = "Verify In Termination Flow , NOTIFY component  ackwonledge backs to Admin API with Sucess message for correct meta data")
	
	
	public void hitNotifyEndpointwithCorrectMetaData(String guid, String carrierLookup, String eventType, int orgID, int sizeOfOrg) {

		MetaDataRequest mdata = new MetaDataRequest();
		mdata.setGuid(guid);
		mdata.setCarrierLookup(carrierLookup);
		mdata.setEventType(eventType);
		mdata.setOrgID(orgID);
		mdata.setSizeOfOrg(sizeOfOrg);

		Log.info("Creating request" );
		RestAdapter request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute()).setStatusCode(200).build();
		
		Log.info("executing request " + response);
		response = request.execute(MetaDataResponse.class);
		
		AllureUtils.step("Verifying the Status Meassage of the  Response ", () -> {
			Assert.assertTrue(response.getMessage().equals("Success"));
		});
		
		AllureUtils.step("Verifying the Guid of the  Response ", () -> {
			Assert.assertTrue(response.getGuid().contentEquals(guid));
		});
		AllureUtils.step("Verifying the carrierLookup of the  Response ", () -> {
			Assert.assertTrue(response.getCarrierLookup().contentEquals(carrierLookup));
		});
		AllureUtils.step("Verifying the eventType of the  Response ", () -> {
			Assert.assertTrue(response.getEventType().contentEquals(eventType));
		});
		AllureUtils.step("Verifying the orgID of the  Response ", () -> {
			Assert.assertTrue(String.valueOf(response.getOrgID()).equalsIgnoreCase(String.valueOf(orgID)));
		});
		AllureUtils.step("Verifying the sizeOfOrg of the  Response ", () -> {
			Assert.assertTrue(String.valueOf(response.getSizeOfOrg()).equals(String.valueOf(sizeOfOrg)));
		});
		System.out.println("Demo Response :" +response.isReceived());
		/*AllureUtils.step("Verifying the isReceived of the  Response ", () -> {
			Assert.assertTrue(response.isReceived());
		});*/
		AllureUtils.step("Verifying the isError of the  Response ", () -> {
			Assert.assertFalse(response.isError());
		});
	
	}
	
	
	
	
	@Severity(SeverityLevel.NORMAL)
	@TmsLink("TC_002")
	@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : PlanSource Benefits System requests should be received by AWS API Gateway")
	@Test(groups = {
			Constants.Termination }, description = "Verify In Termination Flow , NOTIFY component  ackwonledge backs to Admin API with Error message for missing meta data")
	
	
	public void hitNotifyEndpointwithMissingMetaData(String guid, String carrierLookup, String eventType, int orgID, int sizeOfOrg) {

		MetaDataRequest mdata = new MetaDataRequest();
		mdata.setGuid(guid);
		mdata.setCarrierLookup("");
		mdata.setEventType(eventType);
		mdata.setOrgID(orgID);
		mdata.setSizeOfOrg(sizeOfOrg);
		mdata.setAnomaly(false);

		RestAdapter request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute()).setStatusCode(400).build();
		
		Log.info("Creating request" + request);
		response = request.execute(MetaDataResponse.class);	
		
		
		AllureUtils.step("Verifying the Status Meassage of the  Response ", () -> {
			Assert.assertTrue(response.getMessage().trim().contentEquals("CarrierLookup is missing in the request"));
		});
		
		AllureUtils.step("Verifying the Guid of the  Response ", () -> {
			Assert.assertTrue(response.getGuid().contentEquals(guid));
		});
		
		AllureUtils.step("Verifying the eventType of the  Response ", () -> {
			Assert.assertTrue(response.getEventType().contentEquals(eventType));
		});
		AllureUtils.step("Verifying the orgID of the  Response ", () -> {
			Assert.assertTrue(String.valueOf(response.getOrgID()).equalsIgnoreCase(String.valueOf(orgID)));
		});
		AllureUtils.step("Verifying the sizeOfOrg of the  Response ", () -> {
			Assert.assertTrue(String.valueOf(response.getSizeOfOrg()).equals(String.valueOf(sizeOfOrg)));
		});
		/*AllureUtils.step("Verifying the isReceived of the  Response ", () -> {
			Assert.assertTrue(response.isReceived());
		});*/
		AllureUtils.step("Verifying the isError of the  Response ", () -> {
			Assert.assertTrue(response.isError());
		});
	
		
		
		
		
	}

}