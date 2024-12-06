package com.aurelius.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aurelius.authentication.pom.ForgotPassword;
import com.aurelius.authentication.pom.LoginPage;
import com.aurelius.authentication.pom.SignupPage;
import com.aurelius.utility.ConfigDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public LoginPage loginPom;
	public SignupPage signUpPom;
	public ForgotPassword forgotPasswordPom;
	public static WebDriver driver;
	static ConfigDataProvider data = new ConfigDataProvider();

	public static String baseUrl = data.baseUrl();
	public static String reportPath = data.getReportPath();
	public static String ssPath = data.getScreenshotPath();

	@BeforeClass
	public void start_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		loginPom = new LoginPage(driver);
		signUpPom = new SignupPage(driver);
		forgotPasswordPom = new ForgotPassword(driver);
	}

	public static String lastScreenshotPath;

	public static String getScreenshotPath(String testCaseName) throws IOException {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized.");
		}

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

		// Define relative path for the screenshot
		String relativePath = "aureliusReport/screenshots/" + testCaseName + "_" + timestamp + ".png";
		String fullPath = System.getProperty("user.dir") + "/" + relativePath;

		// Create the directory if it doesn't exist
		File dir = new File("aureliusReport/screenshots");
		if (!dir.exists() && !dir.mkdirs()) {
			throw new IOException("Failed to create screenshot directory.");
		}

		// Save the screenshot
		FileUtils.copyFile(source, new File(fullPath));

		return relativePath; // Return the relative path for use in the report
	}

	@AfterClass
	public void close_browser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
