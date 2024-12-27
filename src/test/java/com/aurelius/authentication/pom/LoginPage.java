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

	@FindBy(how = How.XPATH, using = "//ui-input//input[@type='text']")
	private WebElement inValidEmailAddress;

	public void enterInValidEmailAddress() {
		waitForElementToBeVisible(inValidEmailAddress);
		inValidEmailAddress.sendKeys("courageous.giraffe.hegxgmail.com");
	}

	@FindBy(how = How.XPATH, using = "//ui-input//input[@type='text']")
	private WebElement unRegisteredEmailAddress;

	public void enterUnRegisteredEmailAddress() {
		waitForElementToBeVisible(unRegisteredEmailAddress);
		unRegisteredEmailAddress.sendKeys("satishgaware@gmail.com");
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

	public WebElement loginButton() {
		waitForElementToBeVisible(clickOnLoginButton);
		return clickOnLoginButton;
	}

	@FindBy(how = How.XPATH, using = "//div[@role='alert']")
	private WebElement tostMsg;

	public WebElement getTostMsg() {
		waitForElementToBeVisible(tostMsg);
		return tostMsg;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='toast-container']")
	private WebElement tostMsg2;

	public WebElement getTostMsg2() {
		waitForElementToBeVisible(tostMsg2);
		return tostMsg2;
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Dashboard']")
	private WebElement dashboard;

	public WebElement dashboard() {
		waitForElementToBeVisible(dashboard);
		return dashboard;
	}

	@FindBy(how = How.XPATH, using = "//div[text()=' Please enter valid email ']")
	private WebElement emailError;

	public WebElement getEmailError() {
		waitForElementToBeVisible(emailError);
		return emailError;
	}

	@FindBy(how = How.XPATH, using = "//div//core-display-user-name")
	private WebElement displayUserName;

	public void clickOnTheUserName() {
		waitForElementToBeVisible(displayUserName);
		displayUserName.click();
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Logout']")
	private WebElement logout;

	public void clickOnLogout() {
		waitForElementToBeVisible(logout);
		logout.click();
	}
}
