package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/SauceDemoLogin.feature", //will run only this pseciififc feature file
		
		// specify which feature file to run
		// in our case we do say to run all features inside features package
		glue = "com/hrms/steps",//"com"+File.separator+"/hrms/steps"
		//if i leave it empty its gonna look for all files
		// where we can find implementation code for gherkin steps
		// we specify just package
		dryRun = true, 
		//basically maps/checks if there is a corresponding step defintion for the steps that u have in feature file
		// if set to true it'll quickly scan that all gherkin steps have implementation
						// code if set to true, no actual execution will happen
		monochrome = true //makes console output more readable
		,strict = true 
	//	,tags = "@maven" 
		,plugin = { "pretty", "html:target/cucumber-default-report" //if here we only had "pretty" one atttribute we 
		//dont need { } but wehne we have more than one value attribute we have to use { , , }
				}
		)
//how cucumber knows we have duplicate?, it'll tell u with exceptions
//IG: whats the default value of dryruun/monochrome,strict? they are all false,

public class SingleTestRunner {

}