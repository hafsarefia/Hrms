package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbases.BaseClass;

public class PersonalDetailsPageElements extends BaseClass {

//	@FindBy(id="personal_txtEmpFirstName")
//	public WebElement firstname;
//	
//	@FindBy(id="personal_txtEmpLastName")
//	public WebElement lastname;

	@FindBy(id = "personal_cmbNation")
	public WebElement nationalityDD;

	@FindBy(name = "personal[optGender]")
	public List<WebElement> genderRadioGroup;

	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails; 

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;

	@FindBy(id="btnSave")
	public WebElement save;
	//verify
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement verifyEmployee;//profilepic
	
	@FindBy(id="personal_txtEmpFirstName")
	public WebElement firstname;
	
	@FindBy(id="personal_txtEmpLastName")
	public WebElement lastname;
	
	// verify labels
	@FindBy(xpath = "//label[contains(text(),'Full Name')]")
	public WebElement fullnameLabel;

	@FindBy(xpath = "//label[contains(text(),'Employee Id')]")
	public WebElement employeeIdLabel;

	@FindBy(xpath = "//label[contains(text(),'Photograph')]")
	public WebElement photographLabel;

//	@FindBy(xpath = "//div[@id='profile-pic']/h1")
//	public WebElement verifyEmployee;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
