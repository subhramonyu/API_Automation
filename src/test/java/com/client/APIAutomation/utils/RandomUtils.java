package com.client.APIAutomation.utils;

import java.util.Random;

import io.qameta.allure.Step;

/**
 * For creating random data
 * 
 * @author subhra.das
 *
 */

public class RandomUtils {

	private static Random random;

	static {
		random = new Random();
	}

	@Step("Getting random number between 0 and {0}")
	public static int getRandomNumber(int UpperLimit) {
		return random.nextInt(UpperLimit);

	}

}
