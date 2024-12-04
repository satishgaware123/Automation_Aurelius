package com.aurelius.authentication.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends com.aurelius.base.BaseClass {

	private WebDriver localDriver;
	private WebDriverWait wait;

	public LoginPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		wait = new WebDriverWait(remoteDriver, 30);
		PageFactory.initElements(remoteDriver, this);
	}

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@FindBy(how = How.XPATH, using = "//ui-input//input[@type='text']")   
	private WebElement emailAddress;

	public void enterEmailAddress() {
		waitForElementToBeVisible(emailAddress);
		 emailAddress.sendKeys("courageous.giraffe.hegx@instantletter.net");
	}
	public void enterInValidEmailAddress() {
		waitForElementToBeVisible(emailAddress);
		 emailAddress.sendKeys("courageous.giraffe.hegx@");
	}
	public void enterUnRegisteredEmailAddress() {
		waitForElementToBeVisible(emailAddress); 
		emailAddress.sendKeys("satishgaware@gmail.com");
	}
	public void enterInValidEmailAddress2() {
		waitForElementToBeVisible(emailAddress); 
		emailAddress.sendKeys("courageous.giraffe.heg");
	}
	
	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	private WebElement enterPassword;

	public void enterPassword() {
		waitForElementToBeVisible(enterPassword); 
		enterPassword.sendKeys("Admin@123");
	}
	
	@FindBy(how = How.XPATH, using = "//ui-button[@class='login-button']")
	private WebElement clickOnLoginButton;

	public void clickOnLoginButton() {
		waitForElementToBeVisible(clickOnLoginButton); 
		clickOnLoginButton.click();
	}
	
	@FindBy(how = How.XPATH, using = "//div[@role='alert']")
	private WebElement tostMsg;

	public WebElement getTostMsg() {
		waitForElementToBeVisible(tostMsg); 
		return tostMsg;
	}
	@FindBy(how = How.XPATH, using = "//span[text()='Dashboard']")
	private WebElement dashboard;

	public WebElement dashboard() {
		waitForElementToBeVisible(dashboard); 
		return dashboard;
	}
	
	
	
}
