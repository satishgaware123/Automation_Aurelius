package com.aurelius.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aurelius.base.BaseClass;

public class TestSignUpPage extends BaseClass {

	@Test(enabled = false)
	public void testUserWithValidUserEmail() {

	}

	@Test(enabled = true)
	public void verifyThatAfterEnteringTheInvalidOtp() throws Exception {
		driver.get("http://3.25.145.165/auth/signup");
		signUpPom.enterEmail();
		signUpPom.clickOnGetStartedButton();
		signUpPom.enterInvalidOTP();
		signUpPom.clickOnGetStartedButton();
		Assert.assertEquals(loginPom.getTostMsg2().getText(), "×\n" + "Error\n" + "OTP Is Invalid");

	}

	@Test(enabled = false)
	public void verifyThatAfterClickOnResendButtionWaitFor60Secconds() throws Exception {
		driver.get("http://3.25.145.165/auth/signup");
		signUpPom.enterEmail();
		signUpPom.clickOnGetStartedButton();
		Thread.sleep(60000);
		signUpPom.clickOnResend();
//		signUpPom.enterInvalidOTP();
//		signUpPom.clickOnSubmit();
		Assert.assertEquals(loginPom.getTostMsg2().getText(), "×\n" + "Error\n" + "OTP Is Invalid");
	}

}
