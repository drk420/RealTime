package com.opencart.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeTest
	public void start()
	{
		logger = Logger.getLogger("Opencart Framework");
		PropertyConfigurator.configure("Log4jfile.properties");
		logger.info("framework execution started");
	}
	
	@AfterTest
	public void end()
	{
		logger.info("framework execution ended");
	}

	@BeforeMethod
	public void setUp()
	{
		String browser_name = "Chrome";
		
		if(browser_name.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please enter correct browsername");
		}
		driver.get("https://naveenautomationlabs.com/opencart/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
		logger.info("browser launched and url");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("browser closed");
	}
}
