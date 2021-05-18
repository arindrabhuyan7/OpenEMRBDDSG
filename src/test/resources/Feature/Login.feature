@login
Feature: Login
      In order to maintain the medical record
      As a portal manager
      I want to login to OpenEMR Dashboard

  # background is used if we have multiple given conditions
  Background: 
    Given I have "chrome" browser with OpenEMR page

  @invalid
  Scenario: Invalid Credential
    When I enter username as "admin1"
    And I enter password as "pass1"
    And I enter language as "English (Indian)"
    And i click on login
    Then I should get the error message as "Invalid username or password"

  @valid
  Scenario Outline: Valid Credentials
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I enter language as "<language>"
    And i click on login
    Then I should get access to the dashboard with the title "OpenEMR"

    Examples: 
      | username   | password   | language         |
      | admin      | pass       | English (Indian) |
      | physician  | physician  | English (Indian) |
      | accountant | accountant | English (Indian) |
