package com.aurelius.authentication;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
		SignUpPom.enterEmail();
		SignUpPom.clickOnGetStartedButton();
		SignUpPom.enterInvalidOTP();
		SignUpPom.clickOnGetStartedButton();
		AssertJUnit.assertEquals(loginPom.getTostMsg(), "OTP Is Invalid");

	}

	@Test(enabled = false)
	public void verifyThatAfterClickOnResendButtionWaitFor60Secconds() throws Exception {
		driver.get("http://3.25.145.165/auth/signup");
		SignUpPom.enterEmail();
		SignUpPom.clickOnGetStartedButton();
		SignUpPom.enterInvalidOTP();
		SignUpPom.clickOnGetStartedButton();
		SignUpPom.clickOnResend();
		AssertJUnit.assertEquals(SignUpPom.getTostMsg(), "Code has been sent to your mail");
	}

}
