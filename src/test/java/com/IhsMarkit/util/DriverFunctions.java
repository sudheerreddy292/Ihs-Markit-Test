package com.IhsMarkit.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.IhsMarkit.stepdefs.Hooks;

public class DriverFunctions{
	WebDriver driver=Hooks.getDriver();
	 public DriverFunctions() {
		 PageFactory.initElements(Hooks.getDriver(), this);
	}
	
	 public void waitForPageToLoad() {
		 
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	    }
	
	public Boolean waitForElementValueToPresent(WebElement element, String text) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));	
	}
	
	public WebElement waitForElementToPresent(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element));	
	}

}
