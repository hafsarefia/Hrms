@sprint5 @login
Feature: Login

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

  #@error
  #Scenario: Error message validation when login with invalid credentials
    #When I enter invalid username and password and see error message
    #Then 
    #Examples: 
      #| Username | Password   | ErrorMessage        			|
      #| Admin    | Admin123   | Invalid Credentials 			|
      #| Hello    | Syntax123! | Invalid Credentials 			|
      #| Admin    | 				    | Password cannot be empty	|
      #| 		     | Syntax123! | Username cannot be empty  |
