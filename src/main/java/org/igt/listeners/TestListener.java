package org.igt.listeners;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.externaldashboard.SendResultToElastic;
import static org.igt.enums.LogType.*;
import org.igt.reports.ExtentLogger;
import org.igt.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.igt.reports.FrameworkLogger.log;

/**
 * Test Listener class to control the test execution as well as initiate/flush extent report.
 * Mar 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExtentReport
 * @see ExtentLogger
 */
public class TestListener implements ITestListener, ISuiteListener {	
	/**
	 * Method to create Extent report object to initialize the report creation.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to execute Extent Report flush operation to create the report.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) { 
		ExtentReport.tearDownReport();
	}

	/**
	 * Create Extent report to log the data in Extent HTML report and pass the test case description.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public  void onTestStart(ITestResult result) {	
		String description =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
		ExtentReport.createTest(description);
	}

	/**
	 * Log the data in Extent Report, Elastic Search and influxDB for passed test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestSuccess(ITestResult result) {		
		log(PASS,result.getMethod().getMethodName() +" is passed");
		String[] authors =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthors(authors);
		CategoryType categories =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(categories);
		TestType method =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).baseType();
		ExtentReport.addMethod(method);
		SendResultToElastic.sendStatusToElastic(result.getMethod().getDescription(), "PASS");
	}

	/**
	 * Log the data in Extent Report, Elastic Search and InfluxDB for failed test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		
		ExtentLogger.fail(String.valueOf(result.getThrowable()));
		ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true);
		String[] authors =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthors(authors);
		CategoryType categories =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(categories);
		TestType method =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).baseType();
		ExtentReport.addMethod(method);
		SendResultToElastic.sendStatusToElastic(result.getMethod().getDescription(), "FAIL");
	}

	/**
	 * Log the data in Extent Report, Elastic Search, InfluxDB for skipped test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
		SendResultToElastic.sendStatusToElastic(result.getMethod().getDescription(), "SKIP");
	}
	
	/**
	 * Method to call InfluxDb post method at the end of complete execution.
	 * @author Mandeep Sheoran
	 */
	@Override
	public void onFinish(ITestContext context) {

	}
}
