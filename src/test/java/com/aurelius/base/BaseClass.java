
package com.aurelius.base;

import java.util.concurrent.TimeUnit;

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
	public WebDriver driver;
	static ConfigDataProvider data = new ConfigDataProvider();
	public static String baseUrl = data.baseUrl();

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

	@AfterClass
	public void close_browser() {
		if (driver != null) {
			driver.close();
		}
	}
}
