package com.hrms.steps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class DashboardSteps extends CommonMethods {

	@Then("user see dashboard menu is displayed")
	public void user_see_dashboard_menu_is_displayed(DataTable dashboardMenu) {
		List<String> expectedMenu=dashboardMenu.asList();
		List<String> actualMenu= new ArrayList<>();
		
		for(WebElement expected : dashboard.menubar) {
			actualMenu.add(expected.getText());			
		}
		System.out.println(expectedMenu);
		System.out.println(actualMenu);
	}
}
/*
Bayramgul Atageldiyeva  8:10 PM
public void selectHeaderlink(String header) {//Admin ,PIM,Leave,Time,Recruitment,Performance,Dashboard,Directory
	List<WebElement> headerLinks=driver.findElements(By.tagName("ul"));
	for(WebElement link:headerLinks) {
		String text=link.getText();
		if(text.equals(header)) {
			WaitandClick(link);
			
		}*/