package com.automation.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.testcontext.TestContextSetup;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	// Instance variable to hold the shared test context
	protected static TestContextSetup context;
	
	// Constructor: Cucumber will inject TestContextSetup here
	public Hooks(TestContextSetup context) {
		this.context = context;
	}

	
	/**
     * @Before hook runs before each scenario.
     * - Sets up WebDriverManager for Chrome
     * - Creates a new ChromeDriver instance
     * - Maximizes the browser window
     * - Navigates to the base URL
     * - Stores the driver in TestContextSetup so step definitions can use it
     */
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        context.driver = new ChromeDriver();
        context.driver.manage().window().maximize();
        context.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        
    }

    
    /**
     * @After hook runs after each scenario.
     * - Quits the browser if it was initialized
     * - Ensures cleanup so no driver leaks remain
     */
    @After
    public void tearDown() {
        if (context.driver != null) {
        	context.driver.quit();
            System.out.println("Browser closed after all scenarios.");
        }
    }
// // Getter for context if needed
//    public static TestContextSetup getContext() {
//        return context;
//    }
}
