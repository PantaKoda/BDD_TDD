Feature: Account deposits

  Scenario Outline: The user deposits money into the account
    Given that the user's balance is <starting balance> dollars
    When the user deposits <amount> dollars
    Then the user's balance is <new balance>
    Examples:
      | starting balance | amount | new balance |
      | 150              | 1000   | 1150        |


