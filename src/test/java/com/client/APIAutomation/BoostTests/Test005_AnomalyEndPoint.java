package com.client.APIAutomation.BoostTests;
/*package com.planSource.benefitSystem.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.planSource.benefitSystem.api.AWSAPI;
import com.planSource.benefitSystem.api.ContentType;
import com.planSource.benefitSystem.core.AllureUtils;
import com.planSource.benefitSystem.core.HandledException;
import com.planSource.benefitSystem.core.Log;
import com.planSource.benefitSystem.pojo.GetError;
import com.planSource.benefitSystem.pojo.MetaDataRequest;
import com.planSource.benefitSystem.pojo.MetaDataResponse;
import com.planSource.benefitSystem.pojo.errorResponse;
import com.planSource.benefitSystem.restclient.GetAdapter;
import com.planSource.benefitSystem.restclient.PostAdapter;
import com.planSource.benefitSystem.restclient.RestAdapter;
import com.planSource.benefitSystem.utils.Config;
import com.planSource.benefitSystem.utils.Constants;
import com.planSource.benefitSystem.utils.JSONUtils;
import com.planSource.benefitSystem.utils.PropertyUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.path.json.JsonPath;


@Feature("ANOMALY END POINT")
public class Test005_AnomalyEndPoint {
	private PropertyUtils Authtoken;
	private MetaDataResponse   response;
	private MetaDataRequest mdata;
	private JsonPath jpath;
	private String recieptHandle;
	private RestAdapter request;

	@BeforeTest(groups = { Constants.Anomaly}, description = "Initializing the Test")
	public void init() throws IOException {
		Authtoken = PropertyUtils.create(Config.AddPlaceAPI);

	}
	
	
	

	@Story("PS -192206:Develop API end point for Anomaly S3 Bucket")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("PS -192206")
	@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : The notify component publishes the LIMRA payload to the anomaly")
	@Test(priority = 50, groups = { Constants.DEMO,
			Constants.Anomaly }, description = "Verify that the payloads are accessed in the anomaly S3 bucket using the GET Anomaly api endpoint")

	public void hitGetAnomalyEndpoint(String guid, String carrierLookup, String eventType, int orgID, int sizeOfOrg)
			throws JsonMappingException, IOException, InterruptedException, HandledException {

		mdata = new MetaDataRequest();
		mdata.setGuid(guid);
		mdata.setCarrierLookup(carrierLookup);
		mdata.setEventType(eventType);
		mdata.setOrgID(orgID);
		mdata.setSizeOfOrg(sizeOfOrg);

		AllureUtils.step("Requesting the Anomaly payload ", () -> {
		
		request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.ANOMALY_ENDPOINT.getAttribute())
				.setStatusCode(200).build();

		request.execute();
		});
		
		
		AllureUtils.step("Getting the Anomaly payload ", () -> {
		
		request = GetAdapter.builder().setContentType(ContentType.JSON).setRequestObject("")
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.ANOMALY_ENDPOINT.getAttribute())
				.setStatusCode(200).build();
		});
		
		try {

			jpath = request.execute();
			System.out.println("Output :" + jpath.prettyPrint());
			System.out.println(jpath.getString("reeiptHandle"));
			recieptHandle = jpath.getString("reeiptHandle");

		} catch (Exception e) {
			Thread.sleep(6000);
			jpath = request.execute();
			// throw new HandledException("", "Time out error,Please try after
			// some time",e);
		}
		
		
		AllureUtils.step("Getting the Report payload ", () -> {
			//Assert.assertNotNull(jpath.getString("reeiptHandle"));
		});
		
	}
	



	@Story("PS -192206:Develop API end point for Anomaly S3 Bucket")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("PS -192206")
	//@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : The payload should be available in the error queue")
	@Test(priority = 51, groups = { Constants.DEMO,
			Constants.Anomaly }, description = "Verify that the Anomaly payloads are deleted using the DELETE Anomaly api endpoint")

	public void hitDeleteAnomalyEndpoint()
			throws JsonMappingException, IOException, InterruptedException, HandledException {

		AllureUtils.step("Requesting the Anomaly payload ", () -> {
			System.out.println("");
		});

			request = GetAdapter.builder().setContentType(ContentType.JSON)
					.setRequestObject("[\"" + recieptHandle + "\"]").setBaseURL(AWSAPI.BASEURL.getAttribute())
					.setEndPoint(AWSAPI.ANOMALY_ENDPOINT.getAttribute()).setStatusCode(200).build();

	

		try {

			jpath = request.execute();
			//System.out.println("Output :" + jpath.prettyPrint());

		} catch (Exception e) {
			Thread.sleep(6000);
			jpath = request.execute();
			// throw new HandledException("", "Time out error,Please try after
			// some time",e);
		}

		AllureUtils.step("Verifying that Response from Delete Anomaly end point ", () -> {
			//Assert.assertNotNull(jpath.prettyPrint());
		});

	}
	
	
	
	
}*/