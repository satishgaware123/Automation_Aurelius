package com.aurelius.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aurelius.authentication.pom.TestResources;
import com.aurelius.base.BaseClass;

public class TestLoginPage extends BaseClass {

	@Test
	public void VerifyTheUserShouldLogginWithValidCredentials() throws Exception {
//		driver.get(baseUrl+"auth");
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		
	}

	@Test(enabled = true)
	public void VerifyTheUserShouldNotLoginWithInValidCredentials() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterInValidEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
	}

	@Test(enabled = true)
	public void VerifyThatIfUserIsNotRegister() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterUnRegisteredEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
//		System.out.println("errorMsg " + loginPom.getTostMsg().getText());
		Assert.assertEquals(loginPom.getTostMsg().getText(), "User not registered");
	}

	@Test(enabled = true)
	public void VerifyThatShowProperErrorMsgAfterEnteringTheInvalidEmail() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterInValidEmailAddress2();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Assert.assertEquals(loginPom.getTostMsg().getText(), "Email is not Valid");
	}

	@Test
	public void test() {

	}

}
