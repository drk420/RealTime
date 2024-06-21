package com.opencart.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//--------------Obj repo ---------------------
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email_address_txtbox;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password_txtbox;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login_btn;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement error_message;
	
	
	//------------ Action methods ----------------

	public void enterEmailAddress(String email)
	{
		email_address_txtbox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		password_txtbox.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		login_btn.click();
	}
	
	public String getErrorMessage()
	{
		String msg = error_message.getText();
		return msg;
	}
}
