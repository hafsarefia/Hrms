#Author: your.email@your.domain.com
Feature: HRMSB6 210 Admin user should be able to create an employee and login credentials for an employee

  Background: 
    Given user logged in into HRMS
    And user is navigated to Add Employee Page
    When user enters employees firstname and lastname

  Scenario: Acceptance criteria Add new Employee
    And user clicks save button
    Then "cucu berber" is added successfully

  Scenario: Add Employee without employee id
    And user deletes employee id
    And user clicks save button
    Then "cucu berber" is added successfully

  Scenario: AddEmployee and create Login Credentials
    And user clicks on create login checkbox
    And user enters login credentials
    And user clicks save button
    Then "cucu berber" is added successfully
