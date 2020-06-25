package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbases.BaseClass;

public class SauceDemoPageElements {

	@FindBy(id="user-name")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(className="btn_action")
	public WebElement loginBtn;
	
	@FindBy(xpath="//h3[@data-test='error']")
	public WebElement errorMsg;
	
	
	
	public SauceDemoPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
