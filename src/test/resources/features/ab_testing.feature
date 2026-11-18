@abtesting @smoke
Feature: A/B Testing page
  As a site visitor
  I want to open the A/B Testing page
  So that I can see which test variation is displayed

  Scenario: Navigate from the home page to A/B Testing
    Given the user is on the home page
    When the user clicks the "A/B Testing" link
    Then the page URL contains "/abtest"

  Scenario: The A/B Testing heading is one of the variations
    Given the user is on the A/B Testing page
    Then the page heading is one of "A/B Test Control" or "A/B Test Variation 1"
