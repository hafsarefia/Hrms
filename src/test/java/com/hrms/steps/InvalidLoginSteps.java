//package com.hrms.steps;
//
//import com.hrms.utils.CommonMethods;
//import com.hrms.utils.ConfigsReader;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class InvalidLoginSteps extends CommonMethods {
//	
//	@Given("user navigated to HRMS")
//	public void user_navigated_to_HRMS() {
//	    setUp();
//	}
//
//	@When("user enters valid username and invalid password")
//	public void user_enters_valid_username_and_invalid_password() {
//	    login.login(ConfigsReader.getProperty("username"), "wefd23");
//	}
//
//	@Then("user see “Invalid credentials” error message")
//	public void user_see_Invalid_credentials_error_message() {
//	    isDisplayed(login.errorMsg);
//	    tearDown();
//	}
//
//	@When("user enters valid username and empty password")
//	public void user_enters_valid_username_and_empty_password() {
//	    login.login(ConfigsReader.getProperty("username"),"");
//	}
//
//	@Then("user see “Password can not be empty” error message")
//	public void user_see_Password_can_not_be_empty_error_message() {
//	    isDisplayed(login.errorMsg);
//	    tearDown();
//	}
//
//	@When("user enters empty username and valid password")
//	public void user_enters_empty_username_and_valid_password() {
//	    login.login("", ConfigsReader.getProperty("password"));
//	}
//
//	@Then("user see “Username can not be empty” error message")
//	public void user_see_Username_can_not_be_empty_error_message() {
//		isDisplayed(login.errorMsg);
//		tearDown();
//	}
//}