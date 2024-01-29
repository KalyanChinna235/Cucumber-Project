Feature: nopCommerce login

  Scenario: Checking login functionality
    Given user open the application login page
    When user enter valid username and password(Username:"sagarapple@gmail.com",Password:"12345678")
    And click on login button
    Then user should be on Homepage
