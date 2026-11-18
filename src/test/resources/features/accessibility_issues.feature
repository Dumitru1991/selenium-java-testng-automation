@accessibility
Feature: Accessibility Issues page
  As a QA engineer
  I want to check the Accessibility Issues page
  So that I can confirm the accessibility rules are listed

  @smoke
  Scenario: Navigate from the home page to Accessibility Issues
    Given the user is on the home page
    When the user clicks the "Accessibility Issues" link
    Then the page URL contains "/accessibility_issues"

  Scenario: The Accessibility Issues heading is correct
    Given the user is on the Accessibility Issues page
    Then the page heading is "Accessibility Issues"

  Scenario: The image-alt rule row is visible
    Given the user is on the Accessibility Issues page
    Then the "image-alt" rule row is visible

  Scenario: The rules table contains rows
    Given the user is on the Accessibility Issues page
    Then the rules table has at least 1 row
