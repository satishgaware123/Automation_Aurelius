package com.aurelius.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aurelius.authentication.pom.TestResources;
import com.aurelius.base.BaseClass;

public class TestSignUpPage extends BaseClass {

	@Test(enabled = true)
	public void testUserWithValidUserEmail() {

	}

	@Test(enabled = true)
	public void verifyThatAfterEnteringTheInvalidOtp() throws Exception {
		driver.get(TestResources.SINGUP_URL);
		signUpPom.enterEmail();
		signUpPom.clickOnGetStartedButton();
		signUpPom.enterInvalidOTP();
		signUpPom.clickOnGetStartedButton();
		Assert.assertEquals(loginPom.getTostMsg(), "OTP Is Invalid");
	}

	@Test(enabled = true)
	public void verifyThatAfterClickOnResendButtionWaitFor60Secconds() throws Exception {
		driver.get(TestResources.SINGUP_URL);
		signUpPom.enterEmail();
		signUpPom.clickOnGetStartedButton();
		signUpPom.enterInvalidOTP();
		signUpPom.clickOnGetStartedButton();
		Thread.sleep(1000);
		Assert.assertEquals(signUpPom.getTostMsg(), "Code has been sent to your mail"); // corently we are not able to
																						// detect the error pop up
	}

}
