package com.hrms.steps;

import com.hrms.testbases.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoLoginSteps extends CommonMethods{
	@Given("user is on login page")
	public void user_is_on_login_page() {
		BaseClass.driver.get(ConfigsReader.getProperty("url"));
	}

	@When("user enter invalid username")
	public void user_enter_invalid_username() {
	    sendText(sauce.username,"Admin");
	}

	@When("user enter invalid password")
	public void user_enter_invalid_password() {
	    sendText(sauce.password,"123go.s");
	}

	@When("click on login button")
	public void click_on_login_button() {
	    click(sauce.loginBtn);
	}

	@Then("user should see the error message")
	public void user_should_see_the_error_message() {
	   System.err.println("Error message");
	}

	@When("user enter invalid username as {string}")
	public void user_enter_invalid_username_as(String username) {
		//File.separator;//this will return one slash '/'
	   sendText(sauce.username,username);
		System.out.println(username);
	}

	@When("user enter invalid password as {string}")
	public void user_enter_invalid_password_as(String password) {
		sendText(sauce.password,password);
		System.out.println(password);
	}
}
