package com.aurelius.authentication;


import org.testng.annotations.Test;
import com.aurelius.base.BaseClass;
import org.testng.Assert;

public class TestForgotPassword extends BaseClass {

	@Test
	public void verifyThatNavigateToTheForgotPassword() throws InterruptedException {
		driver.get("http://3.25.145.165/auth");
		forgotPasswordPom.clickOnTheForgotPass();
		Assert.assertEquals(driver.getCurrentUrl(), "http://3.25.145.165/auth/forgot-password");

	}

	@Test
	public void verifyThatEnterTheInvalidEmailInForgotPassword() throws InterruptedException {
		driver.get("http://3.25.145.165/auth");
		forgotPasswordPom.clickOnTheForgotPass();
		loginPom.enterUnRegisteredEmailAddress();
		forgotPasswordPom.clckOnSend();
		Assert.assertEquals(loginPom.getTostMsg().getText(), "User Is Not Register Or Email Is Not Verified");

	}

}
