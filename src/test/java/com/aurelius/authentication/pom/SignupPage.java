package com.aurelius.authentication.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	private WebDriver localDriver;
	private WebDriverWait wait;

	public SignupPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		wait = new WebDriverWait(remoteDriver, 30);
		PageFactory.initElements(remoteDriver, this);
	}

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	private WebElement enterTheEmail;

	public void enterEmail() {
		waitForElementToBeVisible(enterTheEmail);
		enterTheEmail.sendKeys("courageous.gi.hegx@instantletter.net");
	}

	@FindBy(how = How.XPATH, using = "//button[@type='button']")
	private WebElement getStartedButton;

	public void clickOnGetStartedButton() {
		waitForElementToBeVisible(getStartedButton);
		getStartedButton.click();
	}

	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	private WebElement enterTheOTP;

	public void enterInvalidOTP() {
		waitForElementToBeVisible(enterTheOTP);
		enterTheOTP.sendKeys("11111");
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Resend ']")
	private WebElement clickOnResend;

	public void clickOnResend() {
		waitForElementToBeVisible(clickOnResend);
		clickOnResend.click();
	}

	public WebElement resendButton() {
		waitForElementToBeVisible(clickOnResend);
		return clickOnResend;
	}

	@FindBy(how = How.XPATH, using = "//button[text()=' Submit ']")
	private WebElement submit;

	public void clickOnSubmit() {
		waitForElementToBeVisible(submit);
		submit.click();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='custom-msg-holder']")
	private WebElement tostMsg;

	public WebElement getTostMsg() {
		waitForElementToBeVisible(tostMsg);
		return tostMsg;
	}

}
