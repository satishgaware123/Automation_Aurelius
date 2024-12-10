package com.aurelius.profile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aurelius.authentication.pom.TestResources;
import com.aurelius.base.BaseClass;

public class TestProfileSection extends BaseClass {

	@Test
	public void verify_user_navigating_to_the_profile_page() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Assert.assertEquals(loginPom.dashboard().getText(), "Dashboard");
//		Thread.sleep(1000);
		profilePom.clickOnTheUserName();
//		Thread.sleep(1000);
		profilePom.clickOnSettings();
//		Thread.sleep(1000);
		Assert.assertEquals(profilePom.priflePageTitle().getText(), "Profile Picture");
	}

}
