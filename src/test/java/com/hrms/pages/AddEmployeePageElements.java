package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeePageElements extends CommonMethods{
	
	@FindBy(id = "firstName")
	public WebElement fname;

	@FindBy(id = "lastName")
	public WebElement lname;

	@FindBy(id = "photofile")
	public WebElement chooseFile;
	
	@FindBy(id="chkLogin")
	public WebElement checkBoxLoginDetails;
		
	@FindBy(id = "employeeId") //xpath ="//input[@id='employeeId']"
	public WebElement employeeId;

	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;
	
	@FindBy(xpath="//select[@id='status']")
	public WebElement status;
	
	@FindBy(id = "btnSave")
	public WebElement save;


	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
		//use BaseClass.driver cuz we did not extend above //this refers to the current class
	}
	
//	public void addingEmployee(String firstname,String lastname) {
//		sendText(fname, firstname);
//		sendText(lname, lastname);
//		click(checkBoxLoginDetails);
////		sendText(this.username, username);
////		sendText(this.password, password);
////		sendText(confirmPassword, confirmPassword);
//	
//	}
	
	public void addEmployee(String firstname, String lastname ) {
		
		sendText(fname, firstname);
		sendText(lname,lastname);
		//sendText(uploadpic, ConfigsReader.getProperty("filePath"));
		//save.click();
	
    }
	public void CreateLogindetails( ) {
		//checkBoxLoginDetails.click();
		sendText(username,ConfigsReader.getProperty("Username"));
		sendText(password,ConfigsReader.getProperty("Password"));
		sendText(confirmPassword, ConfigsReader.getProperty("Password"));
        Select select= new Select (status);
		select.selectByVisibleText("Enabled");
		save.click();
	}
	
}
