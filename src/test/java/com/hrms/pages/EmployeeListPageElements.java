package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class EmployeeListPageElements extends CommonMethods {

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empName;

	@FindBy(id = "empsearch_id")
	public WebElement empId;

	@FindBy(id="searchBtn")
	public WebElement searchBtn;
	
	@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td")
	public List<WebElement> a;
	
	public EmployeeListPageElements() {
		PageFactory.initElements(driver, this);
	}

}
