package com.hrms.testbases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	public static WebDriver setUp() {//return type was void but we changed this for multislectdd class

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);// how do u access the method read
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {//basically switch("chrome") gibi but instead of hard coding we read from th efile

		case "chrome":
			WebDriverManager.chromedriver().setup();//automatically finds the latest version of chrome and uses it 
			//System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			//we wont need system.setproperty bc we are using Webdrivermanager library, we can automatically set up our chromedriver
			driver = new ChromeDriver();// WebDriver driver =
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();//this way is more secured, top sleect by companies
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}

		//waits until page load for implicit 
		//driver.manage().window().maximize();//or fullscreen();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);//i wanna set my implicit wait		
//		driver.get(ConfigsReader.getProperty("url"));//intializing our element
		
		//initialize all page objs as part of setup
		PageInitializer.initialize();//there are diff ways to include our intiliaze 
		
		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
