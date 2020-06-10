package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class LoginPageElements extends CommonMethods{

	// not using pageFactory, u have to extend commonmethods or baseclass
	// public WebElement usernmae2=driver.findElement(By.id("txtUsername"));

	// using PageFactory and @FindBy annotation
	// @FindBy helps us to locate the 
	
	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(name = "txtPassword")
	public WebElement password;

	@FindBy(css = "input#btnLogin")
	public WebElement loginBtn;

	@FindBy(xpath = "//div[@div='divLogo']/img")
	public WebElement logo;

	@FindBy(xpath = "//span[@id='spanMessage']")
	public WebElement errorMsg; //this represents "Invalid username/ cannot have empty usrname and  Csrf token validation failed

	// now we will intialize those elements above all at onceeee
	public LoginPageElements() {
		PageFactory.initElements(driver, this);// BaseClass.driver c we did not extend above //this refers to
															// the current class
	}

	// if we would be keeping elements as private
	// then we will need to create public getters and setters
	// so we can access page elements from test classes

	// setter
	public void sendUsername(String uid) {
		sendText(username, uid);
	}

	// getter
	public WebElement getUsername() {
		return username;
	}
	
	public void login(String uid, String pwd) { //configsreader.getproperty("ueram
		sendText(username,uid);
		sendText(password,pwd);
		click(login.loginBtn);
	}
	
	
}
