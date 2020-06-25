#Author: Refia Senliler refia_hafsa@hotmail.com
Feature: Sauce Demo Login
  Description: US-3421 The purpose of this feature file is 
  			to automate sauce demo app login feature with valid 
  			and invalid credentials
  Acceptance criteria: I want to automate sauce demo login funstionality
  
  i can have comments here, brief descriptions

  #Scenario: Invalid Login
    #Given user is on login page
    #When user enter invalid username
    #And user enter invalid password
    #And click on login button
    #Then user should see the error message

     Scenario: Invalid Login
    Given user is on login page
    When user enter invalid username as "admin"
    And user enter invalid password as "admin@123"
    And click on login button
    Then user should see the error message