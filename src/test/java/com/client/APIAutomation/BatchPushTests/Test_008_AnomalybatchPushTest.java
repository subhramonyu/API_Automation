package com.client.APIAutomation.BatchPushTests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.client.APIAutomation.BatchPush.AnomalyBatchPush;
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

@Feature("ANOMALY BATCH PUSH")
@Epic("PS-193755:Guardian Boost Enrollment API: Support - GL")
public class Test_008_AnomalybatchPushTest {

	private MetaDataRequest mdata;
	private MetaDataRequest mdata2;
	private RestAdapter request;
	private Response response;
	private List<?> responseList;
	private DataProvider data;

	@BeforeTest(groups = { Constants.TEST, Constants.ANOMALYBATCHPUSH, Constants.BATCHPUSH}, description = "Initializing the Test")
	public void init() throws IOException {
		mdata = new MetaDataRequest();
		mdata2 = new MetaDataRequest();
		data = new DataProvider();
	}

	
	
	@Story("PS -193999:Integrate with actual benefits system API to push Anomaly payload")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("14070")
	@Description("PreRequisite : PlanSource Benefits System requests should be received by AWS API Gateway")
	@Test(priority = 80, groups = { Constants.TEST,Constants.ANOMALYBATCHPUSH,Constants.BATCHPUSH },
	description = "Verify Anomaly job scheduler pulls the messages from Anomaly bucket and pushes to PS API on batch scheduler time basis")
	public void anomalyPushwithAllMetaData() throws InterruptedException {

		Log.info("Constructing the first request object");
		mdata.setGuid(data.getData(MetaData.GoodGUID));
		mdata.setCarrierLookup(data.getData(MetaData.carrierLookup));
		mdata.setEventType("term");
		mdata.setOrgID(Integer.parseInt(data.getData(MetaData.orgID)));
		mdata.setSizeOfOrg(Integer.parseInt(data.getData(MetaData.sizeOfOrg)));
		mdata.setAnomaly(true);
		
		Log.info("Creating first request");
		request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute()).build();

		Log.info("Executing the first request" + request);
		response = request.execute();

		Log.info("Verifying the first response code");
		CommonUtils.verifyResponseCode(200, response);

		Log.info("Constructing the second request object");
		mdata2.setGuid(data.getData(MetaData.GoodGUID));
		mdata2.setCarrierLookup(data.getData(MetaData.carrierLookup));
		mdata2.setEventType("term");
		mdata2.setOrgID(mdata.getOrgID());
		mdata2.setSizeOfOrg(mdata.getSizeOfOrg());
		mdata2.setAnomaly(true);
			
		Log.info("Creating second request");
		request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata2)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute()).build();

		Log.info("Executing the second request" + request);
		response = request.execute();
		
		Log.info("Verifying the first response code");
		CommonUtils.verifyResponseCode(200, response);
		
		Log.info("Verifying that the messages from the Anomaly bucket has been consumed ");
		request = GetAdapter.builder().setContentType(ContentType.JSON)
					.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.ANOMALY_ENDPOINT.getAttribute()).build();

		Log.info("TO ensure that the batch process has been run atleast once");
		CommonUtils.wait(8);
		
		
		
		Log.info("Executing the Get request from the Anomaly end point");
		response = request.execute();
		
		Log.info("Getting the messages from the Anomaly bucket");
		responseList = AnomalyBatchPush.getAnomalyResponseAsList(response.asString());
		
		Log.info("Verifying that all messages has been pushed from Anomaly bucket");
		AnomalyBatchPush.verifyEmptyAnomalyBucket(responseList);
		
	}

	
	
	
	

}