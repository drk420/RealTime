package com.opencart.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageLayer.Homepage;
import com.opencart.pageLayer.Loginpage;
import com.opencart.pageLayer.Registerpage;
import com.opencart.testBase.TestBase;

public class RegisterTest extends TestBase {

	@Test
	public void verifyRegisterTestWithValidDetails()
	{
		String expected_result = "Your Account Has Been Created!";
		
		Homepage homepage_obj = new Homepage(driver);
		Registerpage registerpage_obj = new Registerpage(driver);
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnRegisterLink();
		
		registerpage_obj.enterFirstName("david");
		registerpage_obj.enterLastName("test4");
		registerpage_obj.enterEmail("davidtest4@gmail.com");
		registerpage_obj.entertelephone("54654646");
		registerpage_obj.enterPassword("Test@1234");
		registerpage_obj.enterConfirmPassword("Test@1234");
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		
		String actual_result = registerpage_obj.getSuccessfulMessage();
		System.out.println("Actual Result is :- " + actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
		
	}
	
	@Test
	public void verifyRegisterTestWithExistingAccountDetails()
	{
		String expected_result = "Warning: E-Mail Address is already registered!";
		
		Homepage homepage_obj = new Homepage(driver);
		Registerpage registerpage_obj = new Registerpage(driver);
		Loginpage loginpage_obj = new Loginpage(driver);
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnRegisterLink();
		
		registerpage_obj.enterFirstName("david");
		registerpage_obj.enterLastName("test4");
		registerpage_obj.enterEmail("davidtest4@gmail.com");
		registerpage_obj.entertelephone("54654646");
		registerpage_obj.enterPassword("Test@1234");
		registerpage_obj.enterConfirmPassword("Test@1234");
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		
		String actual_result = loginpage_obj.getErrorMessage();
		System.out.println("Actual Result is :- " + actual_result);
		
		Assert.assertEquals(actual_result, expected_result);
		
	}
}
