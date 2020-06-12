@searchEmployee @sprint13
Feature: Employee Search

  Background: 
    And user is logged with valid credentials
    And user navigate to employee list page

  @smoke
  Scenario: Search employee by id
    When user enters valid employee "10099"
    And click on search button
    Then user see employee information is displayed

  @regression
  Scenario: Search employee by name
    When user enters valid employee "Refia" and "Sen"
    And click on search button
    Then user see employee information is displayed
