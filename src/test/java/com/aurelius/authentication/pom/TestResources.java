package com.aurelius.authentication.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aurelius.base.BaseClass;

public class TestResources extends BaseClass {

	private WebDriver driver;

	public TestResources(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static final String LOGIN_URL = baseUrl + "auth";
	public static final String SINGUP_URL = baseUrl + "auth/signup";

}