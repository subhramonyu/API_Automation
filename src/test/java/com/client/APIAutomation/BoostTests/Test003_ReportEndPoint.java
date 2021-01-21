package com.client.APIAutomation.BoostTests;


import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.client.APIAutomation.api.AWSAPI;
import com.client.APIAutomation.api.ContentType;
import com.client.APIAutomation.core.HandledException;
import com.client.APIAutomation.core.Log;
import com.client.APIAutomation.pojo.MetaDataRequest;
import com.client.APIAutomation.restclient.GetAdapter;
import com.client.APIAutomation.restclient.PostAdapter;
import com.client.APIAutomation.restclient.RestAdapter;
import com.client.APIAutomation.utils.CommonUtils;
import com.client.APIAutomation.utils.Constants;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Feature("REPORT END POINT")
public class Test003_ReportEndPoint {

	private Response response;
	private MetaDataRequest mdata;
	private RestAdapter request ;
	private JsonPath jpath;
	private String reeiptHandle;
	

	@BeforeTest(groups = { Constants.DEMO, Constants.Report }, description = "Initializing the Test")
	public void init() throws IOException {
	}

	@Story("PS -192204:Develop API end point for REPORT Queue")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("192204")
	@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : The deliver queue sends the payload response to the guardian sandbox api and the response is sent to the report queue")
	@Test(priority =10 ,groups = { Constants.TEST,
			Constants.Report }, description = "Verify that the response metadata received in the report queue is seen by invoking the GET Report api endpoint")
	public void hitGetReportEndpoint(String guid, String carrierLookup, String eventType, int orgID,
			int sizeOfOrg) throws InterruptedException {

		mdata = new MetaDataRequest();
		mdata.setGuid(guid);
		mdata.setCarrierLookup(carrierLookup);
		mdata.setEventType(eventType);
		mdata.setOrgID(orgID);
		mdata.setSizeOfOrg(sizeOfOrg);
		mdata.setAnomaly(false);

		Log.info("Creating request");
		request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute()).build();

		Log.info("Executing the request" + request);
		response = request.execute();

		Log.info("Verifying the response code");
		CommonUtils.verifyResponseCode(200, response);
		
		Log.info("Getting the requested Data from Get call");
		request = GetAdapter.builder().setContentType(ContentType.JSON).setRequestObject("")
					.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.REPORT_ENDPOINT.getAttribute()).build();
			
		
		
		
		/*
		 * try {
		 * 
		 * jpath = request.execute(); System.out.println("Output :" +
		 * jpath.prettyPrint()); System.out.println(jpath.getString("reeiptHandle"));
		 * reeiptHandle = jpath.getString("reeiptHandle");
		 * 
		 * } catch (Exception e) { Thread.sleep(6000); jpath = request.execute(); //
		 * throw new HandledException("", "Time out error,Please try after // some
		 * time",e); }
		 * 
		 * 
		 * AllureUtils.step("Getting the Report payload ", () -> {
		 * Assert.assertNotNull(jpath.getString("reeiptHandle")); });
		 */
	}
	
	
	

	@Story("PS -192204:Develop API end point for REPORT Queue")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("PS -192204")
	@Description("PreRequisite : The payload should be available in the Report queue")
	@Test(priority = 31, groups = { Constants.DEMO,
			Constants.Report }, description = "Verify that the error payloads are deleted using the DELETE REPORT api endpoint")

	public void hitDeleteErrorEndpoint()
			throws JsonMappingException, IOException, InterruptedException, HandledException {

		/*
		 * AllureUtils.step("Requesting the Error payload ", () -> {
		 * System.out.println(""); });
		 */
			request = GetAdapter.builder().setContentType(ContentType.JSON)
					.setRequestObject("[\"" + reeiptHandle + "\"]").setBaseURL(AWSAPI.BASEURL.getAttribute())
					.setEndPoint(AWSAPI.REPORT_ENDPOINT.getAttribute()).setStatusCode(200).build();

	
			/*
			 * try {
			 * 
			 * jpath = request.execute(); //System.out.println("Output :" +
			 * jpath.prettyPrint());
			 * 
			 * } catch (Exception e) { Thread.sleep(6000); jpath = request.execute(); //
			 * throw new HandledException("", "Time out error,Please try after // some
			 * time",e); }
			 * 
			 * AllureUtils.step("Verifying that Response from Delete ERROR end point ", ()
			 * -> { //Assert.assertNotNull(jpath.getString("reeiptHandle")); });
			 */

	}

}