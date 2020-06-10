package com.hrms.steps;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
//import junit.framework.Assert;


public class AddEmployeeSteps extends CommonMethods {

	@Given("user is logged with valid admin credentials") // does setUp do the same thing here?
	public void user_is_logged_with_valid_admin_credentials() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("user navigates to AddEmployeePage")
	public void user_navigates_to_AddEmployeePage() {
		dashboard.navigateToAddEmployee();
	}

	@When("user enters employees {string} and {string}")
	public void user_enters_employees_first_name_and_last_name(String firstname,String lastname) {
		addEmp.addEmployee(firstname,lastname);//"J", "Balvin");
		//OR sendText(addEmp.fname,"J"); sendText(addEmp.lname,"Balvin"); //we're hardcoding here
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		click(addEmp.save);
		//OR addEmp.save.click();
	}

//	@SuppressWarnings("deprecation")
	@Then("{string} is added succesfully")
	public void employee_is_added_succesfully(String expected) {
		//String expected="J Balvin";
		String actual = pdetails.verifyEmployee.getText();
		Assert.assertEquals(expected, actual);
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
