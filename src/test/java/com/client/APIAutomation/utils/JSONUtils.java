package com.client.APIAutomation.utils;

import java.io.IOException;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * All utility for handling the JSON object and JSON file
 * @author subhra.das
 *
 */
public class JSONUtils {

	/**
	 * This method is used to convert POJO Object to a JSON String...
	 * 
	 * @param obj
	 * @return jsonString
	 */

	public static String getSerializedJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}
	
	
	public static <T> T getDeSerializedJSON(String obj, Class<T> cls)  {
		 T temp = null;
		ObjectMapper mapper = new ObjectMapper();
		//String jsonString = null;
		/*try {
			mapper.readValue(obj, cls);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}*/

		try {
			temp = mapper.readValue(obj, cls);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  temp;
	}

}
