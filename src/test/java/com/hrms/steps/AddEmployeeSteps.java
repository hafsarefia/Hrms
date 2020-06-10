package com.hrms.steps;

import org.testng.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user is logged with valid admin credentials")
	public void user_is_logged_with_valid_admin_credentials() {
	    login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("user navigates to AddEmployeePage")
	public void user_navigates_to_AddEmployeePage() {
	    dashboard.navigateToAddEmployee();
	}
	
	@When("user enters employees {string} and {string}")
	public void user_enters_employees_first_name_and_last_name(String firstname,String lastname) {
	    addEmp.addEmployee(firstname, lastname);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	    addEmp.save.click();
	}

	@Then("{string} is added succesfully")
	public void is_added_succesfully(String expected) {
	    Assert.assertEquals(pdetails.verifyEmployee.getText(), expected, "did not verify");
	}
	
	
}