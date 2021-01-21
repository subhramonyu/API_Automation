package com.client.APIAutomation.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.client.APIAutomation.utils.CommonUtils;

/**
 * This class is mainly for Logging purpose.
 * @author subhra.das
 *
 */
public class Log {

	private static Logger Log;

	static {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));

	}

	/**
	 * To set the logger type for logging
	 * @param : class name of the logger type
	 * @return : Logger object
	 */
	public static Logger setLogger(String ClassName) {
		PropertyConfigurator
				.configure(CommonUtils.getCurrentDirectory() + "/src/test/resources/PropertyFile/Log.properties");
		return Log = Logger.getLogger(ClassName);

	}

	public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String message) {

		Log.error(message);

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}
}
