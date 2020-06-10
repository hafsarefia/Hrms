package com.hrms.testbases;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.EmployeeListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;


//intializes all pages class and stores references in static variables
//that will called/used in test classes
public class PageInitializer extends BaseClass{
	//goal of this class intitialize global varibales/ 12:40 2:40 izle
	//goal is ot intialize all our page classes
	//by doing tehse we're trying t give global access to our page classes(their objects)

	public static LoginPageElements login;
	
	public static DashboardPageElements dashboard;
	
	public static AddEmployeePageElements addEmp;
	
	public static  PersonalDetailsPageElements pdetails;

	public static EmployeeListPageElements elist;
	
	//these are all local w/out anything(public,privateetc)
	//to access from diff packages we can make the public sttaic 
	
	public static void initialize() {

		login = new LoginPageElements();//instantiating objs
		dashboard = new DashboardPageElements();
		addEmp = new AddEmployeePageElements();
		pdetails = new PersonalDetailsPageElements();
		elist = new EmployeeListPageElements();
	}
}
