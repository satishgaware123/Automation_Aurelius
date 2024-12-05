package com.aurelius.authentication;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aurelius.authentication.pom.TestResources;
import com.aurelius.base.BaseClass;

public class TestLoginPage extends BaseClass {

	@Test(enabled = false)
	public void VerifyTheUserShouldLogginWithValidCredentials() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		AssertJUnit.assertEquals(loginPom.dashboard().getText(), "Dashboard");
	}

	@Test(enabled = true)
	public void VerifyTheUserShouldNotLoginWithInValidCredentials() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterInValidEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		AssertJUnit.assertEquals(loginPom.getTostMsg().getText(), "Invalid user name or password");
	}

	@Test(enabled = false)
	public void VerifyThatIfUserIsNotRegister() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterUnRegisteredEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Thread.sleep(2000);
		AssertJUnit.assertEquals(loginPom.getTostMsg().getText(), "Invalid user name or password");
	}

	@Test(enabled = false)
	public void VerifyThatShowProperErrorMsgAfterEnteringTheInvalidEmail() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterInValidEmailAddress2();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		AssertJUnit.assertEquals(loginPom.getTostMsg().getText(), "Email is not Valid");
	}



}
