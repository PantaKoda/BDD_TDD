Feature: Account deposits

  Scenario: The user deposits money into the account
    Given that the user's balance is SEK 100
    When the user deposits SEK 50
    Then the user's balance should be SEK 150



Feature: User wrong login credentials

  Scenario: The user's name is John Doe
    When user logins with wrong name
    Then it will throw an error to retry
