package com.client.APIAutomation.BatchPushTests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.client.APIAutomation.BatchPush.ReportBatchPush;
import com.client.APIAutomation.api.AWSAPI;
import com.client.APIAutomation.api.ContentType;
import com.client.APIAutomation.core.Log;
import com.client.APIAutomation.pojo.MetaDataRequest;
import com.client.APIAutomation.restclient.GetAdapter;
import com.client.APIAutomation.restclient.PostAdapter;
import com.client.APIAutomation.restclient.RestAdapter;
import com.client.APIAutomation.utils.CommonUtils;
import com.client.APIAutomation.utils.Constants;
import com.client.APIAutomation.utils.DataProvider;
import com.client.APIAutomation.utils.Config.MetaData;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;

@Feature("REPORT BATCH PUSH")
@Epic("PS-193755:Guardian Boost Enrollment API: Support - GL")
public class Test_006_ReportbatchPushTest {

	private MetaDataRequest mdata;
	private RestAdapter request;
	private Response response;
	private List<?> responseList;
	private DataProvider data;

	@BeforeTest(groups = { Constants.TEST, Constants.REPORTBATCHPUSH,Constants.BATCHPUSH }, description = "Initializing the Test")
	public void init() throws IOException {
		data = new DataProvider();
	}
	
	@Story("PS -194001:Integrate with actual benefits system API to push Report payload")
	@Story("PS -193791:Creating the scheduler which runs all the report job with scheduled time")
	@Story("PS-193792:Running batch Job which consumes messages from report queue and processing to PS API and finally testing the positive scenarios with test framework")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("14058")
	@Description("PreRequisite : PlanSource Benefits System requests should be received by AWS API Gateway")
	@Test(priority = 60, groups = { Constants.TEST,Constants.REPORTBATCHPUSH,Constants.BATCHPUSH },
	description = "Verify report job scheduler which pulls the messages from Report Queue and push to PS API on batch sceduler time basis")
	public void reportPushwithMetaData() throws InterruptedException {

		Log.info("Constructing the request object");
		mdata = new MetaDataRequest();
		mdata.setGuid(data.getData(MetaData.GoodGUID));
		mdata.setCarrierLookup(data.getData(MetaData.carrierLookup));
		mdata.setEventType(data.getData(MetaData.eventType));
		mdata.setOrgID(Integer.parseInt(data.getData(MetaData.orgID)));
		mdata.setSizeOfOrg(Integer.parseInt(data.getData(MetaData.sizeOfOrg)));
		mdata.setAnomaly(false);

		Log.info("Creating request");
		request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute()).build();

		Log.info("Executing the request" + request);
		response = request.execute();

		Log.info("Verifying the response code");
		CommonUtils.verifyResponseCode(200, response);
		
		Log.info("Verifying that the messages from the report queue has been consumed ");
		request = GetAdapter.builder().setContentType(ContentType.JSON)
					.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.REPORT_ENDPOINT.getAttribute()).build();

		Log.info("TO ensure that the batch process has been run atleast once");
		CommonUtils.wait(6);
		
		Log.info("Executing the Request");
		response = request.execute();
		
		Log.info("Getting the messages from the report queue");
		responseList = ReportBatchPush.getReportResponseAsList(response.asString());
		
		Log.info("Verifying that all messages has been pushed from report queue");
		ReportBatchPush.verifyEmptyReportQueue(responseList);
	}

	
	
	
	

}