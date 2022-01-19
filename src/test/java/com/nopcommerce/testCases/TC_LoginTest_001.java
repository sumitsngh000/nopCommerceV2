package com.nopcommerce.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginTest_001 extends BaseClass {

	@Test(groups={"sanity"})
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User provided"); // logger msg

		lp.setPassword(password);
		logger.info("Password provided");// logger msg

		lp.clickLogin();
		logger.info("Login in Clicked");// logger msg
		Thread.sleep(2000);
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Thread.sleep(5000);
			lp.clickLogout();
			AssertJUnit.assertTrue(true);
			logger.info("Login Passed");// logger msg

		} else {
			captureScreen(driver,"loginTest");
			AssertJUnit.assertTrue(false);
			logger.info("Login Failed");// logger msg
		}

	}
	
}
