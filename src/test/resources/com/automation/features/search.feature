Feature: Search Functionality
  As a user
  I want to search for products
  So that I can quickly find what I need

  Background:
    Given I am on the homepage

  @smoke @search
  Scenario: Search for a valid product
    When I enter "Tom" in the search box
    And I click on the search button
    Then I should see search results related to "Tomato - 1 Kg"

  @regression @search
  Scenario: Search for an invalid product
    When I enter "XRT234" in the search box
    And I click on the search button
    Then I should see search results related to "Sorry, no products matched your search!"