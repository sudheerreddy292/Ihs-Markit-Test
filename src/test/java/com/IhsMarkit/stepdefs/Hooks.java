package com.IhsMarkit.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.IhsMarkit.util.DriverFunctions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverFunctions{
	
//	public WebDriver driver;
	  static WebDriver driver;

	    public static WebDriver createDriver() {
	    	 driver=new ChromeDriver();
	    	 return driver;
	    }
	    
	    public static WebDriver getDriver() {
			return driver;
		}
	    
	@Before
	public void beforeHook(Scenario scenario) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "servers/chromedriver");
		createDriver();
		driver.get("https://dotnetfiddle.net/");
		DriverFunctions driverFunc=new DriverFunctions();
		driverFunc.waitForPageToLoad();
		driver.manage().deleteAllCookies();
		try {
			driver.manage().window().fullscreen();
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}
	
	@After
	public void afterHook(Scenario scenario) throws InterruptedException {
		driver.quit();
	}
	

}
