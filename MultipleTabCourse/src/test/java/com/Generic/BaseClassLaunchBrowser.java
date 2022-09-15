package com.Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClassLaunchBrowser 
{
	public WebDriver driver;
	
	@Parameters("Browsers")
	@BeforeClass
	public void launchBrowser(String Browser) 
		{
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		
		else if(Browser.equalsIgnoreCase("Edge")) 
		{
		System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		}
		
		/*
		 * else if(Browser.equalsIgnoreCase("FireFox")) {
		 * System.setProperty(read.getFirefoxKey(),read.getFirefoxValue()); driver=new
		 * FirefoxDriver(); driver.manage().window().maximize(); }
		 */

		else if(Browser.equalsIgnoreCase("chromeIncognito"))
		{
		System.setProperty("webdriver.edge.driver","./Drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		}
		
		else if(Browser.equalsIgnoreCase("EdgeIncognito"))
		{
		System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
		EdgeOptions option = new EdgeOptions();
		option.setCapability("InPrivate", true);
		
		driver=new EdgeDriver(option);
		driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
}
