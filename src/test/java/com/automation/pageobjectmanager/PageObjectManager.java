package com.automation.pageobjectmanager;

import com.automation.pages.LandingPage;
import com.automation.testcontext.TestContextSetup;

public class PageObjectManager {
	TestContextSetup context;
	LandingPage landingPage;
	
	public PageObjectManager(TestContextSetup context) {
		this.context=context;
	}
	
	//Defining the Landing page object for reusablity 
	
	public LandingPage getLandingPage() {
		
		landingPage = new LandingPage(context);
		return landingPage;
		
	}

}
