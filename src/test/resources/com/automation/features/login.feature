Feature: Login Functionality

Scenario: Login with valid cred
Given User is on login page 
When user enter username "Admin" and password "Password"
And User click on the search button
Then User should be redircted to homepage