package com.aurelius.authentication.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {
	private WebDriver localDriver;
	private WebDriverWait wait;

	public ForgotPassword(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		wait = new WebDriverWait(remoteDriver, 30);
		PageFactory.initElements(remoteDriver, this);
	}

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	@FindBy(how = How.XPATH, using = "//div//label[@class='signup text-orange forgot-pwd-text']")
	private WebElement clickOnTheForgotPass;

	public void clickOnTheForgotPass() {
		waitForElementToBeVisible(clickOnTheForgotPass);
		clickOnTheForgotPass.click();
	}
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement getStartedButton;

	public void clckOnSend() {
		waitForElementToBeVisible(getStartedButton);
		getStartedButton.click();
	}
}
