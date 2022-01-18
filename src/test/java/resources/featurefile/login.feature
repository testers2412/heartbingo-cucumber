Feature: Check main functionality of Home Page

  Background: User is on home page
    Given User is on home page
@Smoke
  Scenario: Verify Login button is working fine
    When User click on Login button
    Then verify user is on Login page

  Scenario Outline: Verify user not able to login with invalid credentials
    When User click on Login button
    And enters username and password "<Username>" "<Password>"
    Then verify the error message "<error>"
    Examples:
      | Username     | Password | error                                                                |
      | PrimeTrainee | Prime123 | The username or password you entered is incorrect. Please try again. |
