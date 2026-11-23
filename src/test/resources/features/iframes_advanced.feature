@iframesadvanced
Feature: Advanced Iframes page
  As a site visitor
  I want to use frames that need more than a plain frame switch
  So that I can check sandboxed, srcdoc and shadow DOM frames work

  @smoke
  Scenario: Navigate from the home page to Advanced Iframes
    Given the user is on the home page
    When the user clicks the "Advanced Iframes" link
    Then the page URL contains "/iframes_advanced"

  Scenario: The Advanced Iframes heading is correct
    Given the user is on the Advanced Iframes page
    Then the page heading is "Advanced Iframes"

  Scenario: The page cannot read the sandboxed frame
    Given the user is on the Advanced Iframes page
    Then the page access status is "The page can't read the sandboxed frame"
    And the message log is "No message yet"

  Scenario Outline: The <frame> frame sends a message to the page
    Given the user is on the Advanced Iframes page
    Then the <frame> frame title is "Frame: <frame>"
    When the user clicks Send a message in the <frame> frame
    Then the send button in the <frame> frame reads "Message sent"
    And the message log is "Message from the <frame> frame: hello"

    Examples:
      | frame     |
      | sandboxed |
      | shadow    |

  Scenario: Read and type inside the srcdoc frame
    Given the user is on the Advanced Iframes page
    Then the srcdoc frame text is "Hello from srcdoc"
    When the user types "Selenium was here" in the srcdoc frame input
    Then the srcdoc frame input contains "Selenium was here"
