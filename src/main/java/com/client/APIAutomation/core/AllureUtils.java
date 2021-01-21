package com.client.APIAutomation.core;
import java.util.UUID;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.util.ResultsUtils;

/**
 * This is a Allure utility for customized steps
 * @author subhra.das
 *
 */
public class AllureUtils {
	
	
	private static void step(String name, Runnable runnable) {
	    String uuid = UUID.randomUUID().toString();
	    StepResult result = new StepResult()
	            .setName(name);
	    Allure.getLifecycle().startStep(uuid, result);
	    try {
	        runnable.run();
	        Allure.getLifecycle().updateStep(uuid, s -> s.setStatus(Status.PASSED));
	    } catch (Throwable e) {
	        Allure.getLifecycle().updateStep(uuid, s -> s
	                .setStatus(ResultsUtils.getStatus(e).orElse(Status.BROKEN))
	                .setStatusDetails(ResultsUtils.getStatusDetails(e).orElse(null)));
	        throw e;
	    } finally {
	        Allure.getLifecycle().stopStep(uuid);
	    }
	}
	
	 public static void step(String stepName) {
		step(stepName, ()-> {});
	    }
	
	
}