package com.opencart.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.opencart.testBase.TestBase;

public class ListenerSetup extends TestBase implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test case execution started :- " + result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test case execution completed :- " + result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test case execution failed :- " + result.getName());
		UtilClass.captureScreenshot(result.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test case execution skipped :- " + result.getName());
	}
}
