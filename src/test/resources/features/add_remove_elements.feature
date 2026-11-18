@addremove
Feature: Add/Remove Elements page
  As a site visitor
  I want to add and remove elements
  So that I can check the page updates the list of elements correctly

  @smoke
  Scenario: Navigate from the home page to Add/Remove Elements
    Given the user is on the home page
    When the user clicks the "Add/Remove Elements" link
    Then the page URL contains "/add_remove_elements"

  Scenario: The Add/Remove Elements heading is correct
    Given the user is on the Add/Remove Elements page
    Then the page heading is "Add/Remove Elements"

  Scenario: No Delete buttons are shown when the page loads
    Given the user is on the Add/Remove Elements page
    Then 0 Delete buttons are displayed

  Scenario Outline: Add <count> element(s)
    Given the user is on the Add/Remove Elements page
    When the user clicks Add Element <count> times
    Then <count> Delete buttons are displayed

    Examples:
      | count |
      | 1     |
      | 5     |

  Scenario Outline: Add <added> elements and delete <deleted>
    Given the user is on the Add/Remove Elements page
    And the user clicks Add Element <added> times
    When the user deletes <deleted> elements
    Then <remaining> Delete buttons are displayed

    Examples:
      | added | deleted | remaining |
      | 3     | 1       | 2         |
      | 3     | 3       | 0         |
