@login

Feature: WebDriver University - Login

  Scenario: Validate Successful Login - Unique Data
    Given I access the webdriver university login us page
    When I enter a unique user name
    And I enter a unique password
    And I click on the login button
    Then I should be presented with a unsuccessful login message

  Scenario: Validate Successful Login - Specific Data
    Given I access the webdriver university login us page
    When I enter a specific user name webdriver
    And I enter a specific password webdriver123
    And I click on the login button
    Then I should be presented with a successful login message
