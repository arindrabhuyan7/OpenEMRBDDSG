@patient
Feature: Patient
      In order to maintain the patient record
      As a admin
      I want to create, update, delete patient record

  Scenario Outline: Add Patient
    Given I have "chrome" browser with OpenEMR page
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I enter language as "<language>"
    And i click on login
    And I mousehover on patient-client
    And I click on patients
    And I click on add new patient
    And I fill the patient detail
      | firstname   | lastname   | dob   | gender   |
      | <firstname> | <lastname> | <dob> | <gender> |
    And I click on create new patient
    And I click on confirm create new patient
    And I handle alert
    And I close happy birthday pop up when available
    Then I validate alert message receiver  "Assessment: Tobacco"
    And I validate the added patient details "<expectedvalue>"

    Examples: 
      | username | password | language         | firstname | lastname | dob        | gender | expectedvalue                       |
      | admin    | pass     | English (Indian) | ashp      | cena     | 2021/05/17 | Male   | Medical Record Dashboard - asho cena |
      | admin    | pass     | English (Indian) | jinp      | cena     | 2021/05/17 | Female | Medical Record Dashboard - jino cena |
