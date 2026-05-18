package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.core.PageBase;
import com.automation.testcontext.TestContextSetup;

public class LandingPage extends PageBase{

	public LandingPage(TestContextSetup context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	By searchInputField = By.xpath("//input[@type='search']");
	By searchButton = By.xpath("//button[@class=\"search-button\"]");
	By expectedResulttext = By.xpath("(//h4[@class=\"product-name\"])[1]");
	By noResultText = By.cssSelector("div[class='no-results'] h2");
	
	public void enterSearchItem(String name) {
		sendKeys(searchInputField, name, "Sending the value to search input filed", 10);
	}
	
	public void clickOnSearchButton() {
		clickButton(searchButton, "Clickcing on the Search Button", 10);
	}
	
	public void validateSerchedResult(String expactedValue) throws InterruptedException{
		Thread.sleep(2000);
		if(isElementVisible(expectedResulttext)) {
			String message = getText(expectedResulttext);
			Assert.assertEquals(expactedValue, message);
		}
		else {
			String message = getText(noResultText);
			Assert.assertEquals(expactedValue, message);
		}
		
	}
}
