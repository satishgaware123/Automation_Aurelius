package com.aurelius.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aurelius.authentication.pom.TestResources;
import com.aurelius.base.BaseClass;

public class TestLoginPage extends BaseClass {
	@Test(enabled = true)
	public void VerifyTheUserShouldLogginWithValidCredentials() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Assert.assertEquals(loginPom.dashboard().getText(), "Dashboard");
		loginPom.clickOnTheUserName();
		loginPom.clickOnLogout();
		Thread.sleep(2000);
	}

	@Test(enabled = true)
	public void VerifyThatAfterSuccessfullyLoginUserShouldLogoutAfterClickOnTheLogoutButton() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Thread.sleep(2000);
		loginPom.clickOnTheUserName();
		loginPom.clickOnLogout();
		Thread.sleep(2000);
		Assert.assertEquals(loginPom.loginButton().getText(), "Login");
		Assert.assertEquals(driver.getCurrentUrl(), TestResources.LOGIN_URL);

	}

	@Test(enabled = true)
	public void VerifyTheUserShouldNotLoginWithInValidCredentials() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterInValidEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Assert.assertEquals(loginPom.getEmailError().getText(), "Please enter valid email");
	}

	@Test(enabled = true)
	public void VerifyThatIfUserIsNotRegister() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterUnRegisteredEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Thread.sleep(2000);
		Assert.assertEquals(loginPom.getTostMsg().getText(), "Bad Authentication");
	}

	@Test(enabled = true)
	public void VerifyThatShowProperErrorMsgAfterEnteringTheInvalidEmail() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterInValidEmailAddress2();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Assert.assertEquals(loginPom.getEmailError().getText(), "Please enter valid email");
	}

}
