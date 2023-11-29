Feature: Money Transfer Between Accounts

  As a bank customer
  I want to transfer money between my accounts

  Scenario: Successful money transfer from one account to another
    Given the user has two accounts AccountA and AccountB
    And AccountA balance is 500
    And AccountB balance is 300
    When the user transfers 200 from AccountA to AccountB
    Then AccountA balance should be 300
    And AccountB balance should be 500

  Scenario: Attempt to transfer more money than in the account
    Given the user has two accounts AccountA and AccountB
    And AccountA balance is 400
    And AccountB balance is 200
    When the user tries to transfer 500 from AccountA to AccountB
    Then the transfer should be declined
    And AccountA balance should remain 400
    And AccountB balance should remain 200
