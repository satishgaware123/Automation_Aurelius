package com.aurelius.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aurelius.base.BaseClass;

public class TestSignUpPage extends BaseClass {

	@Test(enabled = false)
	public void testUserWithValidUserEmail() {

	}

	@Test(enabled = false)
	public void verifyThatAfterEnteringTheInvalidOtp() throws Exception {
		driver.get("http://3.25.145.165/auth/signup");
		signUpPom.enterEmail();
		signUpPom.clickOnGetStartedButton();
		signUpPom.enterInvalidOTP();
		signUpPom.clickOnGetStartedButton();
		Assert.assertEquals(loginPom.getTostMsg(), "OTP Is Invalid");

	}

	@Test(enabled = false)
	public void verifyThatAfterClickOnResendButtionWaitFor60Secconds() throws Exception {
		driver.get("http://3.25.145.165/auth/signup");
		signUpPom.enterEmail();
		signUpPom.clickOnGetStartedButton();
		signUpPom.enterInvalidOTP();
		signUpPom.clickOnGetStartedButton();
		signUpPom.clickOnResend();
		Assert.assertEquals(signUpPom.getTostMsg(), "Code has been sent to your mail");
	}

}
