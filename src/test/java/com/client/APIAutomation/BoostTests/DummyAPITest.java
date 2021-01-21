package com.client.APIAutomation.BoostTests;
/*package com.planSource.benefitSystem.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.planSource.benefitSystem.api.PlaceAPI;
import com.planSource.benefitSystem.core.AllureUtils;
import com.planSource.benefitSystem.core.Log;
import com.planSource.benefitSystem.pojo.AddPlace;
import com.planSource.benefitSystem.restclient.ContentType;
import com.planSource.benefitSystem.restclient.PostAdapter;
import com.planSource.benefitSystem.restclient.RestAdapter;
import com.planSource.benefitSystem.utils.Config;
import com.planSource.benefitSystem.utils.Constants;
import com.planSource.benefitSystem.utils.PropertyUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

@Story("Create  User ")
@Feature("Create the Users through API")
public class DummyAPITest {
	private PropertyUtils Authtoken;
	private AddPlace response;

	@BeforeTest(groups = { Constants.DEMO }, description = "Initializing the Test")
	public void init() throws IOException {
		Authtoken = PropertyUtils.create(Config.AddPlaceAPI);

	}

	@TmsLink("Demo-001")
	@Parameters({ "name", "job" })
	@Description("User can be created by POST Call ")
	@Test(groups = { Constants.DEMO }, description = "Create User by POST call Test")
	public void createUser(String name, String job) {

		AddPlace ad = new AddPlace();
		ad.setName(name);
		ad.setJob(job);
		
		RestAdapter request = PostAdapter.builder().setContentType(ContentType.JSON).setRequestObject(ad)
				.setBaseURL(PlaceAPI.BASEURL.getAttribute()).setEndPoint(PlaceAPI.ADD_ENDPOINT.getAttribute()).build();
		Log.info("Creating request" + request );
		response = request.executeWithOutParam(AddPlace.class);
		Log.info("executing request " + response);
	}

	@TmsLink("Demo-002")
	@Parameters({ "name", "job" })
	@Description("Verify the Created User by Post call ")
	@Test(groups = { Constants.DEMO }, description = "Verify the Created User Test")
	public void verifyCreatedUser(String name, String job) {
		AllureUtils.step("Verifying the name and Job title from the Response ", () -> {
			Assert.assertTrue(response.getName().equalsIgnoreCase(name) && response.getJob().equalsIgnoreCase(job));
		});

	}

	
	
}*/