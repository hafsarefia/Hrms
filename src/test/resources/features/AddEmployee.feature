Feature: Add new Employee
	
  Background: 
    Given user is logged with valid admin credentials
    And user navigates to AddEmployeePage

  @smoke
  Scenario: Add Employee with first and lastname  
    When user enters employees "J" and "Balvin"
    And user clicks save button
    Then "J Balvin" is added succesfully

  @regression
  Scenario: Add Employee without employee id
    When user enters employees "Ma" and "Balvin"
    And user deletes employee id
    And user clicks save button
    Then "Ma Balvin" is added succesfully

  Scenario: AddEmployeePage and create Login Credentials
    When user enters employees "I love" and "Cucumber"
    And user clicks on create login checkbox
    And user enters login credentials
    And user clicks save button
    Then "J Balvin" is added succesfully

  #to perform DDT in cucumber we use Scenario Outline with Examples
  @working
  Scenario Outline: Adding multiple employees
    When user enter employees "<FirstName>", "<MiddleName>", and "<LastName>"
    And user clicks save button
    Then "<FirstName>", "<MiddleName>", and "<LastName>" is added successfully

    Examples: 
      | FirstName | MiddleName | LastName  |
      | James     | J          | Smith     |
      | Faisal    | F          | Sakhi     |
      | Sohil     | S          | Instuctor |
      | Yunus     | Emre       | Yakut     |

  #adding multiple employees using Cucumber DataTable
  @inProgress
  Scenario: Adding multiple employees
    When user enters employee details and click on save then employee is added
      | FirstName | MiddleName | LastName |
      | John      | J          | Doe      |
      | Jane      | J          | Smith    |
  #@excel
  #Scenario: Adding multiple employees from excel
    #When user enters employer data from "EmployeeLoginCredentials"
    #
