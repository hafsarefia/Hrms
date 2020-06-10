#Feature: Login with valid credentials
#
  #User with different roles should be able to login into HRMS application
  #Scenario: User should be be able to login as an Admin using valid admin credentials
    #When user enters valid admin username and password
    #And user clicks on login button
    #Then user should be able to see "Welcome Admin" message
#		#Admin  successfully logged in
#
  #Scenario: User should be be able to login as an ESS using valid employee credentials
    #When user enters valid employee(ess) username and password
    #And user clicks on login button
    #Then user should be able to see "Welcome refis" message
    #ess successfully logged in
 #
  #Scenario: Login with valid username and invalid password
    #When user enters vaiid username and invalid password
    #And user click on login button
    #Then user see Invalid Credentials text on login page
