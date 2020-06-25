package com.hrms.steps;

import org.testng.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EmployeeSearchSteps extends CommonMethods {

	@Given("user is navigated to HRMS")
	public void user_is_navigated_to_HRMS() {
		setUp();
	}

	@Given("user is logged with valid credentials")
	public void user_is_logged_with_valid_credentials() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("user navigates to employee list page")
	public void user_navigates_to_employee_list_page() {
		dashboard.navigateToEmployeeList();
	}

	@When("user enters valid employee {string}")
	public void user_enters_valid_employee(String id) {
		sendText(elist.empId, "23255");
	}

	@When("click on search button")
	public void click_on_search_button() {
		click(elist.searchBtn);
	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
//		isDisplayed(elist.verify); isDisplayedList<> method kur
		boolean display = elist.verify.isDisplayed();//List<WebElement>
		Assert.assertTrue(display,"The employee information is not displayed");
	}

	@When("user enters valid employee {string} and {string}")
	public void user_enters_valid_employee_and(String fname, String lname) {
//		sendText(elist.f);
	}

	@When("user enters valid employee {string}")
	public void user_enters_valid_employee_id(String employeeId) {
		sendText(elist.empId, employeeId);
	}

	@When("user enters valid employee credentials")
	public void user_enters_valid_employee_credentials() {

	}
}
