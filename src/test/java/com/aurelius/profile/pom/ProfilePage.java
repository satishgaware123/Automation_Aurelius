package com.aurelius.profile.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aurelius.base.BaseClass;

public class ProfilePage extends BaseClass {

	private WebDriver localDriver;
	private WebDriverWait wait;

	public ProfilePage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		wait = new WebDriverWait(remoteDriver, 30);
		PageFactory.initElements(remoteDriver, this);
	}

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	@FindBy(how = How.XPATH, using = "//div//core-display-user-name")
	private WebElement displayUserName;

	public void clickOnTheUserName() {
		waitForElementToBeVisible(displayUserName);
		displayUserName.click();
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Settings']")
	private WebElement settings;

	public void clickOnSettings() {
		waitForElementToBeVisible(settings);
		settings.click();
	}

	@FindBy(how = How.XPATH, using = "//div[text()='Profile Picture']")
	private WebElement getProfilePictireTittle;

	public WebElement priflePageTitle() {
		waitForElementToBeVisible(getProfilePictireTittle);
		return getProfilePictireTittle;
	}

}
