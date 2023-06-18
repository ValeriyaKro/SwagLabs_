Feature: User Login
  As a user
  I want to log in with different users
  So that I can access my account

  Scenario Outline: User Login
    Given User is on the login page
    When User enters "<username>" and password
    And User clicks on the login button
    Then User should be logged in successfully

    Examples:
      | username        |
      | standard_user   |

  Scenario: User can logout successfully
    Given User is logged in
    When User clicks on the logout button
    Then User should be logged out successfully
