@searchEmployee @sprint13
Feature: Employee Search

  Background: 
  	Given user is navigated to HRMS
    And user is logged with valid admin credentials
    And user navigates to employee list page

  @smoke
  Scenario: Search employee by id
    When user enters valid employee "10098"
    And click on search button
    Then user see employee information is displayed

  @regression
  Scenario: Search employee by name
    When user enters valid employee "Refia" and "Sen"
    And click on search button
    Then user see employee information is displayed
