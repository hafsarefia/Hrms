package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
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
	
	@When("user enters employee details and click on save then employee is added")
	public void user_enters_employee_details_and_click_on_save_then_employee_is_added(DataTable dataTable) {//, String expected ca i use this inside?
		List<Map<String, String>> addEmployeeList = dataTable.asMaps();// we'll get 1 list of maps

		for (Map<String, String> map : addEmployeeList) {
//			System.out.println(map.get("FirstName"));
//			System.out.println(map.get("MiddleName"));
//			System.out.println(map.get("LastName"));
			// instead of syso
			String fname=map.get("FirstName");
			String mname= map.get("MiddleName");
			String lname=map.get("LastName");
			sendText(addEmp.fname, fname);//map.get("FirstName")
			sendText(addEmp.midname, mname);//map.get("LastName")
			sendText(addEmp.lname, lname);//or inside this map.get("LastName")
			click(addEmp.save);
			//another way could be pass expected as a parameter 
			String expected=fname+" "+mname+" "+lname;
			String actual = pdetails.verifyEmployee.getText();
			Assert.assertEquals("Employee is not added successfully",expected, actual);
			jsClick(dashboard.addEmployee);
			wait(3);
		}
	}
}