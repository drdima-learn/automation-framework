@login @regression

Feature: WebDriver University - Login

  Background:
    Given I access the webdriver university login page


  Scenario: Validate unsuccessful Login - Unique Data
    When I enter a unique user name
    And I enter a unique password
    And I click on the login button
    Then I should be presented with a unsuccessful login message

  @login1
  Scenario: Validate Successful Login - Specific Data
    When I enter a specific user name webdriver
    And I enter a specific password webdriver123
    And I click on the login button
    Then I should be presented with a successful login message

  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter a username <username>
    When I enter a password <password>
    And I click on the login button
    Then I should be presented with the following validation message <loginValidationMessage>

    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | webdriver1   | validation failed      |
      | joe_blogs | password1    | validation failed      |
