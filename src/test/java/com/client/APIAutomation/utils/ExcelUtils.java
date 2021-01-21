package com.client.APIAutomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * All utility for handling xlsx and CSV file
 * @author subhra.das
 *
 */

public class ExcelUtils {

	public static Workbook book;
	public static Sheet sheet;

	public static String TESTDATA_SHEET_PATH = ""
			+ "/src/main/java/com/qa/api/gorest/testdata/GoRestTestData.xlsx";

	
	/**
	 * 
	 * @param sheetName
	 * @return
	 */
	
	public static Object[][] getTestData(String sheetName) {

		try {
			FileInputStream ip = new FileInputStream(TESTDATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}

		return data;

	}

}
