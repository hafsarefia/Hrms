package com.hrms.steps;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HRMSB6210 extends CommonMethods{
	@Given("user logged in into HRMS")
	public void user_logged_in_into_HRMS() {
	    login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
	}

	@Given("user is navigated to Add Employee Page")
	public void user_is_navigated_to_Add_Employee_Page() {
	    dashboard.hoverOverAddEmployee();
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
	    addEmp.employeeId.clear();	
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
	    jsClick(addEmp.checkBoxLoginDetails);
	}

	@When("user enters login credentials")
	public void user_enters_login_credentials() {
	    addEmp.CreateLogindetails();
	}

}
