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
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aurelius.authentication.pom.ForgotPassword;
import com.aurelius.authentication.pom.LoginPage;
import com.aurelius.authentication.pom.SignupPage;
import com.aurelius.profile.pom.ProfilePage;
import com.aurelius.utility.ConfigDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ProfilePage profilePom;
	public LoginPage loginPom;
	public SignupPage signUpPom;
	public ForgotPassword forgotPasswordPom;
	public static WebDriver driver;
	static ConfigDataProvider data = new ConfigDataProvider();

	public static String baseUrl = data.baseUrl();
	public static String reportPath = data.getReportPath();
	public static String ssPath = data.getScreenshotPath();

	public static boolean isHeadless = true;

	@BeforeClass
	public void start_browser() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		if (isHeadless) {
			options.addArguments("--headless");
		}
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		loginPom = new LoginPage(driver);
		signUpPom = new SignupPage(driver);
		forgotPasswordPom = new ForgotPassword(driver);
		profilePom = new ProfilePage(driver);
	}

	public static String lastScreenshotPath;

	public static String getScreenshotPath(String testCaseName) throws IOException {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized.");
		}
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		String relativePath = "aureliusReport/screenshots/" + testCaseName + "_" + timestamp + ".png";
		String fullPath = System.getProperty("user.dir") + "/" + relativePath;
		File dir = new File("aureliusReport/screenshots");
		if (!dir.exists() && !dir.mkdirs()) {
			throw new IOException("Failed to create screenshot directory.");
		}
		FileUtils.copyFile(source, new File(fullPath));
		return relativePath;
	}

	@AfterClass
	public void close_browser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
