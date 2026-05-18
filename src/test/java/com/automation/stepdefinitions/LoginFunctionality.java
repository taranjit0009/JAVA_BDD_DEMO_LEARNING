package com.automation.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginFunctionality {

	@Given("User is on login page")
	public void validateUserIsOnLoginPage() {
		System.out.print("User is on the Login page.");
	}
	
	@When("user enter username {string} and password {string}")
	public void loginFunctionality(String username, String password) {
		System.out.println("user enters the username and password : "+username+" , "+password);
	}
	
	@When("User click on the search button")
	public void clickOnLoginButton() {
		System.out.println("Clickon on login button");
	}
	
	@Then("User should be redircted to homepage")
	public void validateLogin() {
		System.out.println("User us logged in succesfully.");
	}
}
