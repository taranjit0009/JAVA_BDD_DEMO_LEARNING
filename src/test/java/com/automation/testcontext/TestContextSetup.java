package com.automation.testcontext;

import org.openqa.selenium.WebDriver;

import com.automation.pageobjectmanager.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	
	public PageObjectManager pageObjectManager;
	
	public TestContextSetup() {
		pageObjectManager = new PageObjectManager(this);
	}
}
