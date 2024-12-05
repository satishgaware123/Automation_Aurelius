
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
	public SignupPage SignUpPom;
	public ForgotPassword forgotPasswordPom;
	public static WebDriver driver;
	static ConfigDataProvider data = new ConfigDataProvider();
	public static String baseUrl = data.baseUrl();
	public static String reportPath= data.getReportPath();
	public static String ssPath= data.getScreenshotPath();

	@BeforeClass
	public void start_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("http://3.25.145.165/auth");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPom = new LoginPage(driver);
		SignUpPom = new SignupPage(driver);
		forgotPasswordPom = new ForgotPassword(driver);
	}
	public String getScreenshotPath(String testCaseName) throws IOException {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized.");
		}

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		String screenshotDir = ssPath;

		File dir = new File(screenshotDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		String destinationFile = screenshotDir + testCaseName + "_" + timestamp + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

	@AfterClass
	public void close_browser() {
		if (driver != null) {
			driver.close();
		}
	}
}
