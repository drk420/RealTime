package com.opencart.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageLayer.Homepage;
import com.opencart.pageLayer.Loginpage;
import com.opencart.testBase.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void verifyLoginTestWithValidDetails()
	{
		String expected_result = "My Account";
		
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnLoginLink();
		
		logger.info("naviagted to login page");
		loginpage_obj.enterEmailAddress("davidtest1@gmail.com");
		loginpage_obj.enterPassword("Test@1234");
		loginpage_obj.clickOnLoginButton();
		
		logger.info("logged in");
		
		String actual_result = driver.getTitle();
		logger.info("Actual Result is :- " + actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void verifyLoginTestWithInvalidDetails()
	{
		String expected_result = "Warning: No match for E-Mail Address and/or Password.";
		
		Homepage homepage_obj = new Homepage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnLoginLink();
		logger.info("naviagted to login page");
		
		loginpage_obj.enterEmailAddress("davidtest1@gmail.com");
		loginpage_obj.enterPassword("Test");
		loginpage_obj.clickOnLoginButton();
		
		logger.info("logged i");
		
		String actual_result = loginpage_obj.getErrorMessage();
		logger.info("Actual Result is :- " + actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
	}
}
