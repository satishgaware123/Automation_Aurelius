package com.aurelius.profile;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aurelius.authentication.pom.TestResources;
import com.aurelius.base.BaseClass;

public class TestProfileSection extends BaseClass {

	@Test(enabled = false)
	public void verify_user_navigating_to_the_profile_page() throws Exception {
		driver.get(TestResources.LOGIN_URL);
		loginPom.enterEmailAddress();
		loginPom.enterPassword();
		loginPom.clickOnLoginButton();
		Assert.assertEquals(loginPom.dashboard().getText(), "Dashboard");
		Thread.sleep(1000);
		profilePom.clickOnTheUserName();
		Thread.sleep(1000);
		profilePom.clickOnSettings();
		Thread.sleep(1000);
		Assert.assertEquals(profilePom.priflePageTitle().getText(), "Profile Picture");
	}

	@Test(enabled = true)
	public void printAllUrlsFromThePage() throws Exception {
		driver.get("https://oculusproxies.com/");
		List<WebElement> allUrls = driver.findElements(By.xpath("//a[@href]"));
		int count = 0;
		for (WebElement url : allUrls) {
			count++;
			String textUrl = url.getText();
			if (!textUrl.isBlank()) {
				System.out.println(textUrl);
			}
		}
		System.out.println("total links on web page " + count);
	}

	@Test(enabled = false)
	public void findBrokenLink() throws Exception {
		driver.get("https://oculusproxies.com/");
		List<WebElement> allUrls = driver.findElements(By.xpath("//a[@href]"));
		int count = 0;
		for (WebElement url : allUrls) {
			String link = url.getAttribute("href");
			URL aURL = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) aURL.openConnection();
			connection.setConnectTimeout(30000);
			connection.connect();
			int responseCode = connection.getResponseCode();
			count++;
			String textUrl = url.getText();
			if (!textUrl.isBlank()) {
				if (responseCode == 200) {
					System.out.println("working link " + textUrl);
				} else {
					System.out.println("broken Link " + textUrl);
				}
			}
		}
		System.out.println("total links on web page " + count);
	}
}
