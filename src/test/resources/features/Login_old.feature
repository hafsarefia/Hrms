Feature: Login

  @smoke
  Scenario: valid admin login
    When user enter valid admin username and password
    And user click on login button
    Then admin user is successfully logged in

  @smoke
  Scenario: valid ess login
    When user enter valid ess username and password
    And user click on login button
    Then ess user is succesfully logged in

#enhancing test with Scenario Outline to login as admin and ess user
  @smoke
  Scenario Outline: 
    When user enter valid "<Username>" and "<Password>"
    And user click on login button
    Then "<FirstName>" user is successfully logged in

    Examples: 
      | Username | Password    | FirstName |
      | Admin    | Hum@NHRM123 | Admin     |
      | abd77    | Syntax123!  | Abdullah  |

#enhancing test with Scenario Outline to login as admin and ess user
#we can delette this scenario
  @smoke
  Scenario: Login with valid username and invalid password
    When User enter valid username and invalid password
    And user click on login button
    Then User see Invalid Credentials text on login page

  @temp
  Scenario: Login with invalid credentials
    When I enter invalid username and password and see error message
      | Username | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Hello    | Syntax123! | Invalid Credentials |
      #@smoke
  #Scenario: valid admin login
    #Given user is navigated to HRMS
    #When user enter valid admin username and password
    #And user click on login button
    #Then admin user is successfully logged in
#
  #@smoke
  #Scenario: valid ess login
    #Given user is navigated to HRMS
    #When user enter valid ess username and password
    #And user click on login button
    #Then ess user is successfully logged in
#
  #@smoke
  #Scenario: Login with valid username and invalid password
    #Given user is navigated to HRMS
    #When User enter valid username and invalid password
    #And user click on login button
    #Then User see Invalid Credentials text on login page
