package com.client.APIAutomation.utils;

import java.io.IOException;
import java.util.stream.Stream;

import io.qameta.allure.Step;

/**
 * Contains Data Configurations
 * @author subhra.das
 *
 */
public class Config {

	private static int GUID;
	private static String propertyValueHolder;
	public static String AddPlaceAPI;
	
	@Step("Getting  Guid....")
	protected static String getGUID(IsSuccess value) {
		if (value.get()) {
			try {
				propertyValueHolder = PropertyUtils.create(
						CommonUtils.getCurrentDirectory() + "\\src\\test\\resources\\PropertyFile\\GUIDs.properties")
						.getProperties("goodGUIDs");
				int[] data = Stream.of(propertyValueHolder.split(",")).mapToInt(Integer::parseInt).toArray();
				GUID = data[RandomUtils.getRandomNumber(data.length)];
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (!value.get()) {
			try {
				propertyValueHolder = PropertyUtils.create(
						CommonUtils.getCurrentDirectory() + "\\src\\test\\resources\\PropertyFile\\GUIDs.properties")
						.getProperties("badGUIDs");
				int[] data = Stream.of(propertyValueHolder.split(",")).mapToInt(Integer::parseInt).toArray();
				GUID = data[RandomUtils.getRandomNumber(data.length)];
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return String.valueOf(GUID);

	}

	
	public enum MetaData {

		GoodGUID, 
		BadGUID, 
		carrierLookup,
		eventType,
		orgID,
		sizeOfOrg,
		anomaly;

		
	}
	
	
	public enum IsSuccess {

		YES(true), NO(false);

		private boolean Attribute;

		IsSuccess(boolean Attribute) {
			this.Attribute = Attribute;
		}

		public boolean get() {
			return Attribute;
		}
	}

}
