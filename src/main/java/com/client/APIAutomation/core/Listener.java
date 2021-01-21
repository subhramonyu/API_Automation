package com.client.APIAutomation.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.Status;
import com.client.APIAutomation.utils.CommonUtils;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

/**
 * For handling the test execution status and count.
 * Better reporting
 * @author subhra.das
 *{@link}
 *
 */
public class Listener extends TestListenerAdapter {

	private static File logFile ;
	private static FileAppender apiLog ;
	public Listener() {
		Log.setLogger("Listener");
	}

	@Override
	public void onStart(ITestContext iTestContext) {

	}

	/**
	 * This gives on the count of the test  at the finish of everything
	 */
	@Override
	public void onFinish(ITestContext context) {
		Log.info("Number of Passed Tests: " + context.getPassedTests().getAllMethods().size());
		Log.info("Failed Tests: " + context.getFailedTests().getAllMethods());
		Log.info("Skipped Tests: " + context.getSkippedTests().getAllMethods());
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		clearLogs();
		writeLogs(result);
		Log.info("X");
		Log.info("X");
		Log.info("****************result************************************************************************");
		Log.info("$$$$$$$$$$$$$$$$$$$$$       "+"Test Case started: "+result.getName()+"    $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.info("X");
		Log.info("X");
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		
	}

	
	@Step("Test Passed. Logs is Attached:")
	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("X");
		Log.info("X");
		Log.info("XXXXXXXXXXXXXXXXXXXXXX    "+"TEST CASE PASSED:"+result.getName()+ "XXXXXXXXXXXXXXXXXXXXXX");
		//saveTextLog(getTestMethodName(result));
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		stopLogAppender();
		appendLogToAllure(logFile,result.getName());
		attachLog(logFile,result.getName());
		clearLogs();
	}

	@Step("Test Failed. Please take a look at the logs attached:")
	@Override
	public void onTestFailure(ITestResult result) {
		Log.info("X");
		Log.info("X");
		Log.info("XXXXXXXXXXXXXXXXXXXXXX    "+"TEST CASE FAILED:"+result.getName()+ "    XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("****************************************************************************************");
		Log.info("****************************************************************************************");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		stopLogAppender();
		appendLogToAllure(logFile,result.getName());
		attachLog(logFile,result.getName());
		clearLogs();
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		Log.info("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		clearLogs();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	/**
	 * Creates runtime logs for each test using FileAppender
	 * @param iTestResult
	 */
	private static void writeLogs(ITestResult iTestResult){
		apiLog = new FileAppender();
        logFile = new File(CommonUtils.getCurrentDirectory()+"/LogsFile/TestLogs/Test.log");
        apiLog.setName("APILOG");
        apiLog.setFile(logFile.getAbsolutePath());
       // apiLog.setEncoding("UTF-8");
        apiLog.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
        apiLog.setImmediateFlush(true);
        apiLog.setThreshold(Level.DEBUG);
        apiLog.activateOptions();
        apiLog.setAppend(false);
        Logger.getRootLogger().addAppender(apiLog);
	}

	private static void stopLogAppender() {
		Logger.getRootLogger().removeAppender("APILOG");
		apiLog.close();
	}
	
	private static void clearLogs() {
		
		try{
	        BufferedWriter bw = new BufferedWriter(new FileWriter(CommonUtils.getCurrentDirectory()+"/LogsFile/TestLogs/Test.log"));
	        bw.write("");
	        bw.flush();
	        bw.close();
	    }catch(IOException ioe){
	        // You should really do something more appropriate here
	        ioe.printStackTrace();
	    }
	}
	
	/**
	 * attach logs to allure report for every test in downloadable format
	 * @param file
	 * @param name
	 * @return byte[]
	 */
	  @Attachment(value = "{1}", type = "logs")
	    private byte[] appendLogToAllure(File file,String name) {
	        try {
	            return FileUtils.readFileToByteArray(file);
	        } catch (IOException ignored) {
	        }
	        return null;
	    }
	  
	  /**
	   * Attach logs to allure report for every test in readable format
	   * @param file
	   * @param name
	   * @return byte[]
	   */
	  @Attachment(value = "{1}", type = "text/html")
	    private byte[] attachLog(File file,String name) {
	        try {
	            return FileUtils.readFileToByteArray(file);
	        } catch (IOException ignored) {
	        }
	        return null;
	    }
	
	  // Text attachments for Allure
	@Attachment(value = "{0}", type = "logs")
	public static String saveTextLog(String message) {
		
		return message;
	}

	// HTML attachments for Allure
	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}
	
	@Attachment(value = "{0}", type = "logs")
	public String logOutput(List<String> outputList) {
	    String output = ""; 
	    for (String o : outputList) 
	        output += o + "<br/>"; 
	    return output;
	}

}
