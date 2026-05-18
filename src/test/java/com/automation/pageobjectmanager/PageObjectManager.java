package com.automation.pageobjectmanager;

import com.automation.pages.LandingPage;
import com.automation.testcontext.TestContextSetup;

public class PageObjectManager {
	
	// Holds the shared scenario context (driver, utilities, managers, etc.)
	TestContextSetup context;
	
	 // Reference to the LandingPage object
	LandingPage landingPage;
	
	/**
     * Constructor Injection:
     * ----------------------
     * - Cucumber will inject the same TestContextSetup instance here
     *   that was also injected into Hooks and Step Definitions.
     * - This ensures all classes in a scenario share the same driver
     *   and state without relying on static variables.
     */
	public PageObjectManager(TestContextSetup context) {
		this.context=context;
	}
	
	//Defining the Landing page object for reusablity 
	 /**
     * Page Object Getter:
     * -------------------
     * - Provides a reusable instance of LandingPage.
     * - Uses the shared context to pass dependencies (like WebDriver).
     * - Centralizes object creation so step definitions don’t need to
     *   instantiate page objects directly.
     */
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(context);
		return landingPage;
		
	}

}
