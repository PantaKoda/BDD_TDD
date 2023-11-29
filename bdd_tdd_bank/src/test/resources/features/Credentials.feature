Feature: Login Validation in Banking App


  Scenario: Entering an incorrect username during login
    Given User is the login page
    When User enters invalid username
    And clicks on login Button
    Then User should see a message informing of an incorrect username


  Scenario: User forgot password
    Given User is in the login page
    And user clicks on forgot password Button
    Then User should see a message to enter email
