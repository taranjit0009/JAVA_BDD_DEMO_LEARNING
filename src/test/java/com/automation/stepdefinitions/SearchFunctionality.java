package com.automation.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.pages.LandingPage;
import com.automation.testcontext.TestContextSetup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFunctionality {

	WebDriver driver;
	TestContextSetup context;
	LandingPage landingPage;

	// Constructor Injection
	public SearchFunctionality(TestContextSetup context) {
		this.context = context;
		this.landingPage = context.pageObjectManager.getLandingPage();
	}

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {

	}

	@When("I enter {string} in the search box")
	public void i_enter_in_the_search_box(String keyword) {
		System.out.println("*************************************" + keyword + "++++++++++++++++++++++++++++++++");
		landingPage.enterSearchItem(keyword);
	}

	@When("I click on the search button")
	public void i_click_on_the_search_button() {
		landingPage.clickOnSearchButton();
	}
	@Then("I should see search results related to {string}")
	public void i_should_see_search_results_related_to(String expectedMessage) throws InterruptedException {
		landingPage.validateSerchedResult(expectedMessage);
	}

}
