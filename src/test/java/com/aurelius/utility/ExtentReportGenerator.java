package com.aurelius.utility;

import com.aurelius.base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator extends BaseClass {

	public static ExtentReports generateReport() {

		String ReportPath = reportPath;

		ExtentSparkReporter repoter = new ExtentSparkReporter(ReportPath);

		repoter.config().setDocumentTitle("Aurelius_Web_Aplication");

		repoter.config().setReportName("Aurelius_Test_Result");

		repoter.config().setTheme(Theme.STANDARD);

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(repoter);

		extent.setSystemInfo("aplication Type", "Web_Application");
		extent.setSystemInfo("Application name", "Aurelius");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("QA Name", "Satish Gaware");
		extent.setSystemInfo("OS", "Linux");

		return extent;

	}

}
