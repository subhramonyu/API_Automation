package com.client.APIAutomation.core;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.client.APIAutomation.utils.CommonUtils;
import com.client.APIAutomation.utils.Constants;
import com.client.APIAutomation.utils.PropertyUtils;
import com.google.common.collect.ImmutableMap;

/**
 * Configuration of the Environment
 * 
 * @author subhra.das
 *
 */

@Listeners(Listener.class)
public class SetUp {
	private Listener listner;

	@BeforeSuite(description = "Setting up the environment", groups = { Constants.DEMO, Constants.TEST,
			Constants.REPORTBATCHPUSH, Constants.ERRORBATCHPUSH, Constants.ANOMALYBATCHPUSH, Constants.Enrollment,
			Constants.Termination, Constants.Error, Constants.Report, Constants.Anomaly,Constants.FAP ,Constants.BATCHPUSH})

	@Parameters({ "project", "module", "ReleaseVersion", "Environment", "ExecutedBy" })

	public void setEnv(String project, String module, String ReleaseVersion, String Environment, String ExecutedBy)
			throws IOException {
		listner = new Listener();
		allureEnvironmentWriter(ImmutableMap.<String, String>builder().put("PROJECT", project).put("MODULE", module)
				.put("Release Version", ReleaseVersion).put("Environment", Environment).put("Executed By", ExecutedBy)
				.build(), System.getProperty("user.dir") + "/allure-results/");

		Log.setLogger("ApplicationLogs");
		System.setProperty("allure.link.tms.pattern",
				PropertyUtils.create(
						CommonUtils.getCurrentDirectory() + "\\src\\test\\resources\\PropertyFile\\JIRA.properties")
						.getProperties("tmslink"));
	}

	/*
	 * @BeforeTest public void getAuthToken(){
	 * 
	 * }
	 */

}
