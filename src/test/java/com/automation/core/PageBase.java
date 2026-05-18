package com.automation.core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.testcontext.TestContextSetup;

public class PageBase {
	
	protected WebDriver driver;
	protected TestContextSetup testContextSetup;
	public PageBase(TestContextSetup context) {
		this.driver=context.driver;
		this.testContextSetup=context;
	}
	public boolean isElementVisible(By locator) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        return true; // element is visible
	    } catch (TimeoutException e) {
	        return false; // element not visible within timeout
	    }
	}

	
	public void clickButton(By locator,String message, int duration) {
		
		driver.findElement(locator).click();
		
	}
	
	public void sendKeys(By locator, String value, String message, int duration) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));

	    WebElement element = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(locator));

	    element.clear();

	    element.sendKeys(value);

	    System.out.println(message);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

}
