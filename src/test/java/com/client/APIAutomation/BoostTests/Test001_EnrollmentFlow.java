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
import com.client.APIAutomation.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;



@Feature("ENROLLMENT FLOW")
public class Test001_EnrollmentFlow {

	private MetaDataResponse response;

	@BeforeTest(groups = { Constants.TEST,Constants.Enrollment }, description = "Initializing the Test")
	public void init() throws IOException {
	}

	@Story("PS -191195:NOTIFY component will receive request from Benefits System and respond acknowledgment to Benefits System")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("TC_001")
	@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : PlanSource Benefits System requests should be received by AWS API Gateway")
	@Test(groups = {
			Constants.TEST ,Constants.Enrollment}, description = "Verify Notify Component will recieve a request from the AWS API gatewayand respond back with Success mesage")
	public void hitNotifyEndpointwithAllMetaData(String guid, String carrierLookup, String eventType, int orgID,
			int sizeOfOrg) {

		MetaDataRequest mdata = new MetaDataRequest();
		mdata.setGuid(guid);
		mdata.setCarrierLookup(carrierLookup);
		mdata.setEventType(eventType);
		mdata.setOrgID(orgID);
		mdata.setSizeOfOrg(sizeOfOrg);
		mdata.setAnomaly(false);

		RestAdapter request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute())
				.setStatusCode(200).build();
		Log.info("Creating request" + request);
		response = request.execute(MetaDataResponse.class);

		Log.info("executing request " + response);

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
		/*
		 * AllureUtils.step("Verifying the isReceived of the  Response ", () ->
		 * { Assert.assertTrue(response.isReceived()); });
		 */
		AllureUtils.step("Verifying the isError of the  Response ", () -> {
			Assert.assertFalse(response.isError());
		});

	}

	@Story("PS -192590:The validation failed requests should be returned as 400-Bad Request")
	@Severity(SeverityLevel.NORMAL)
	@TmsLink("TC_002")
	@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : PlanSource Benefits System requests should be received by AWS API Gateway")
	@Test(groups = {
			Constants.TEST ,Constants.Enrollment}, description = "Verify Notify Component will recieve a request from the AWS API gatewayand respond back with Missing error mesage")
	public void hitNotifyEndpointwithMissingMetaData(String guid, String carrierLookup, String eventType, int orgID,
			int sizeOfOrg) {

		MetaDataRequest mdata = new MetaDataRequest();
		mdata.setGuid(guid);
		mdata.setCarrierLookup("");
		mdata.setEventType(eventType);
		mdata.setOrgID(orgID);
		mdata.setSizeOfOrg(sizeOfOrg);
		mdata.setAnomaly(false);

		RestAdapter request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute())
				.setStatusCode(400).build();
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
		/*
		 * AllureUtils.step("Verifying the isReceived of the  Response ", () ->
		 * { Assert.assertTrue(response.isReceived()); });
		 */
		AllureUtils.step("Verifying the isError of the  Response ", () -> {
			Assert.assertTrue(response.isError());
		});

	}

}