package com.automation.testcontext;

import org.openqa.selenium.WebDriver;

import com.automation.pageobjectmanager.PageObjectManager;
import com.automation.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContextSetup {
	public WebDriver driver;
	public ConfigReader configReader;
	public String browser;
	public String URL;
	public String env= "PROD";

	public PageObjectManager pageObjectManager;

	public TestContextSetup() {
		
		 // Initialize ConfigReader once per scenario
		configReader = new ConfigReader(env);
		browser = configReader.getBrowserName();
		URL = configReader.getURL();
		// Initialize PageObjectManager with this context
		pageObjectManager = new PageObjectManager(this);
	}
}
