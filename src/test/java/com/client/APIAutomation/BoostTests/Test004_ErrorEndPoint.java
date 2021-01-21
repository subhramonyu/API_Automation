package com.client.APIAutomation.BoostTests;
/*package com.planSource.benefitSystem.tests;

import java.io.IOException;

import org.aspectj.apache.bcel.classfile.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.planSource.benefitSystem.api.AWSAPI;
import com.planSource.benefitSystem.api.ContentType;
import com.planSource.benefitSystem.core.AllureUtils;
import com.planSource.benefitSystem.core.HandledException;
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

@Feature("ERROR END POINT")
public class Test004_ErrorEndPoint {
	private PropertyUtils Authtoken;
	private MetaDataResponse response;
	private MetaDataRequest mdata;
	private JsonPath jpath;
	private errorResponse errorResponse;
	private String recieptHandle;
	private RestAdapter request;

	@BeforeTest(groups = { Constants.DEMO, Constants.Error }, description = "Initializing the Test")
	public void init() throws IOException {
		Authtoken = PropertyUtils.create(Config.AddPlaceAPI);

	}

	@Story("PS -192205:Develop API end point for ERROR Queue")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("PS -192205")
	@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : The payload should be available in the error queue")
	@Test(priority = 40, groups = { Constants.DEMO,
			Constants.Error }, description = "Verify that the error payloads are invoked or accessed using the GET ERROR api endpoint")

	public void hitGetErrorEndpoint(String guid, String carrierLookup, String eventType, int orgID, int sizeOfOrg)
			throws JsonMappingException, IOException, InterruptedException, HandledException {

		mdata = new MetaDataRequest();
		mdata.setGuid(guid);
		mdata.setCarrierLookup(carrierLookup);
		mdata.setEventType(eventType);
		mdata.setOrgID(orgID);
		mdata.setSizeOfOrg(sizeOfOrg);

		AllureUtils.step("Requesting the Error payload ", () -> {
		
		request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(mdata)
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.NOTIFY_ENDPOINT.getAttribute())
				.setStatusCode(200).build();

		request.execute();
		});
		
		
		AllureUtils.step("Getting the Error payload ", () -> {
		
		request = GetAdapter.builder().setContentType(ContentType.JSON).setRequestObject("")
				.setBaseURL(AWSAPI.BASEURL.getAttribute()).setEndPoint(AWSAPI.ERROR_ENDPOINT.getAttribute())
				.setStatusCode(200).build();
		});
		
		try {

			jpath = request.execute();
			System.out.println("Output :" + jpath.prettyPrint());

		} catch (Exception e) {
			Thread.sleep(6000);
			jpath = request.execute();
			// throw new HandledException("", "Time out error,Please try after
			// some time",e);
		}

		GetError[] error = JSONUtils.getDeSerializedJSON(jpath.prettyPrint(), GetError[].class);

		AllureUtils.step("Verifying the Error payload ", () -> {
			
		});
			for (int i = 0; i <= error.length; i++) {
				recieptHandle = error[i].getReeiptHandle();
				errorResponse = error[i].getErrorResponse();
				String payload = errorResponse.getPayload();
				if (payload.contains(mdata.getGuid())) {
					break;
				}

			}
	

		System.out.println("Error recipt Handle :" + error[0].getReeiptHandle());

	}

	@Story("PS -192205:Develop API end point for ERROR Queue")
	@Severity(SeverityLevel.CRITICAL)
	@TmsLink("PS -192205")
	@Parameters({ "guid", "carrierLookup", "eventType", "orgID", "sizeOfOrg" })
	@Description("PreRequisite : The payload should be available in the error queue")
	@Test(priority = 41, groups = { Constants.DEMO,
			Constants.Error }, description = "Verify that the error payloads are deleted using the DELETE ERROR api endpoint")

	public void hitDeleteErrorEndpoint()
			throws JsonMappingException, IOException, InterruptedException, HandledException {

		AllureUtils.step("Requesting the Error payload ", () -> {
			System.out.println("");
		});

			request = GetAdapter.builder().setContentType(ContentType.JSON)
					.setRequestObject("[\"" + recieptHandle + "\"]").setBaseURL(AWSAPI.BASEURL.getAttribute())
					.setEndPoint(AWSAPI.ERROR_ENDPOINT.getAttribute()).setStatusCode(200).build();

	

		try {

			jpath = request.execute();
			System.out.println("Output :" + jpath.prettyPrint());

		} catch (Exception e) {
			Thread.sleep(6000);
			jpath = request.execute();
			// throw new HandledException("", "Time out error,Please try after
			// some time",e);
		}

		AllureUtils.step("Verifying that Response from Delete ERROR end point ", () -> {
			//Assert.assertNotNull(jpath.prettyPrint());
		});

	}

}*/