package com.hrms.steps;


import com.hrms.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {
	@Given("user is logged with valid credentials")
	public void user_is_logged_with_valid_credentials() {

	}

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {

	}

	@When("user enters valid employee {string}")
	public void user_enters_valid_employee_id(String employeeId) {
		sendText(elist.empId, employeeId);
	}

	@When("click on search button")
	public void click_on_search_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user enters valid employee credentials")
	public void user_enters_valid_employee_credentials() {

	}
}
