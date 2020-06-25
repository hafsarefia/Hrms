package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbases.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(id = "welcome")
	public WebElement welcome;

	@FindBy(xpath = "//div[@id='branding']/a[1]/img")
	public WebElement logo;

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pim;

	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement employeeList;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmployee;
	
	@FindBy(id="menu_core_viewDefinedPredefinedReports")
	public WebElement reports;

	@FindBy(id = "menu_recruitment_viewRecruitmentModule")
	public WebElement recruitment;

	@FindBy(id = "menu_recruitment_viewCandidates")
	public WebElement candidates;
	
	@FindBy(xpath="//div[@class='menu']/ul/li")
	public List<WebElement> menubar;//dashmenu

	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void navigateToAddEmployee() { // can i include actions here?
//		click(pim);
//		click(addEmployee);
		//OR
		jsClick(pim);
		jsClick(addEmployee);
		// try if u can do actions hover bluh bluh
		// if click() is not working then use jsClick()
	}
	
	public void hoverOverAddEmployee() {
		Actions action = new Actions(driver);
		action.moveToElement(pim).perform();
		click(addEmployee);
	}
	public void navigateToEmployeeList() {
		click(pim);
		click(employeeList);
	}
	
	//one way
	public void navigateToCandidates() {
		click(recruitment);
		click(candidates);
	}
	//another way
	public void hoverOverCandidates() {
	Actions action = new Actions(driver);//
	action.moveToElement(recruitment).perform();
	click(candidates);
	}
	
	public void navigateToReports() {
		click(pim);
		click(reports);
	}
	
	public void hoverOverReports() {
		Actions  action = new Actions(driver);
		action.moveToElement(pim).perform();
		click(reports);
	}
	
	/*
	 * @FindBy(id = "welcome") private WebElement welcome;
	 */ // u have to use getters/setters
}
