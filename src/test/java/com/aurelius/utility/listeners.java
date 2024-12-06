package com.aurelius.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aurelius.base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listeners extends BaseClass implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReportGenerator.generateReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName() + " -> " + result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Case Passed: " + result.getMethod().getMethodName());
		System.out.println(colorText("Test Case Passed: " + result.getMethod().getMethodName(), "green"));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, "Test Case Failed: " + result.getMethod().getMethodName());
		extentTest.get().log(Status.FAIL, "Error: " + result.getThrowable());
		System.out.println("Test Case Failed: " + result.getMethod().getMethodName());

		try {
			if (BaseClass.driver != null) {
				String screenshotPath = BaseClass.getScreenshotPath(result.getMethod().getMethodName());
				String absolutePath = System.getProperty("user.dir") + "/" + screenshotPath;
//				System.out.println("Relative Path: " + screenshotPath);
//				System.out.println("Absolute Path: " + absolutePath);
				extentTest.get().addScreenCaptureFromPath(absolutePath, "Failure Screenshot");
			} else {
				extentTest.get().log(Status.FAIL, "Driver is not initialized. Screenshot not captured.");
			}
		} catch (Exception e) {
			extentTest.get().log(Status.FAIL, "Failed to attach screenshot due to: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Case Skipped: " + result.getMethod().getMethodName());
		extentTest.get().log(Status.SKIP, "Reason: " + result.getThrowable());
		System.out.println(colorText("Test Case Skipped: " + result.getMethod().getMethodName(), "yellow"));
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	private String colorText(String message, String color) {
		String resetColor = "\033[0m";
		String coloredText;

		switch (color.toLowerCase()) {
		case "green":
			coloredText = "\033[0;32m" + message + resetColor;
			break;
		case "red":
			coloredText = "\033[0;31m" + message + resetColor;
			break;
		case "yellow":
			coloredText = "\033[0;33m" + message + resetColor;
			break;
		default:
			coloredText = message;
		}

		return coloredText;
	}
}
