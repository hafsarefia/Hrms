package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbases.PageInitializer;

public class CommonMethods extends PageInitializer {
	/**
	 * Method that clears and sends keys
	 * 
	 * @param element
	 * @param text
	 */

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}

	/**
	 * Method checks if radio/checkbox is enabled and clicks it
	 * 
	 * @param radioOrcheckbox
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> radioOrcheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrcheckbox) {
			actualValue = el.getAttribute("value").trim();// 1st we're gonna retrieve the value
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}

	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement cell : element) { // cell = pickDate
			if (cell.isEnabled()) {
				if (cell.getText().equals(text)) {
					cell.click();
					break;
				}
			}
		}
	}

	// create calendar

//	List<WebElement> rows = dayRows;
//	int rowNums = rows.size();
//	List<WebElement> cols = dayCols;
//	int colNums = cols.size();
//	System.out.println("column number is "+rowNums+"\nColumn number is "+colNums);
//	
//	for(int i=1; i<rowNums; i++) {	
//		for(int j=1; j<colNums; j++) {
//			WebElement cell = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr["+i+"]/td["+j+"]"));
//			//String text = cell.getText();
//			if(j==16) {
//				cell.click();
//			}
//		}
//	}
	/**
	 * Methods that checks if text is there and then selects it
	 * 
	 * @param element
	 * @param textToSelect
	 * 
	 */
	public static void selectDDValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);
//			select.selectByVisibleText(textToSelect);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				if (option.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			} // why we use for loop herE?why we di dnot do directly isSelect etc ?
				// bc i wanna verify and check if the text there is matching and then select
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods that values by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDDValue(WebElement element, Integer index) {

		try {
			Select select = new Select(element);
			int size = select.getOptions().size();
			if (size > index) {
				select.selectByIndex(index);

			}
		} catch (UnexpectedTagNameException e) {
			e.getStackTrace();
		}

	}

	// kendim isdiplayed yazmaya calsirken which one is better?

	public static void isDisplayed(WebElement element) {

		boolean isDisplayed = element.isDisplayed();
		String text = element.getText(); // this used for comparing , text represents label/attributes

		if (element.isDisplayed()) {// or i can do element.isDisplayed()
			System.out.println(text + " is displayed: " + isDisplayed);// +isDisplayed);
		} else {
			System.out.println(text + " is not displayed: " + isDisplayed);// + isDisplayed);
		}
	}
//	
//	public static void isDisplayed(List<WebElement> element) {
//
//		boolean isDisplayed = element.isDisplayed();
//		String text = element.getText(); // this used for comparing , text represents label/attributes
//
//		if (element.isDisplayed()) {// or i can do element.isDisplayed()
//			System.out.println(text + " is displayed: " + isDisplayed);// +isDisplayed);
//		} else {
//			System.out.println(text + " is not displayed: " + isDisplayed);// + isDisplayed);
//		}
//	}
//	public static void isDisplayedAssert() {
//		
//	}

	/**
	 * Methods that accept alerts and catches excep=tion if alert is not present
	 */
	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods that dismiss alerts and catches exception if alert is not present
	 */
	public static void dismissAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods that accgets text of alert and catches exception if alert is not
	 * present
	 * 
	 * @return
	 */
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}

	/**
	 * Methods that accept alerts and catches exception if alert is not present
	 * 
	 */
	public static String sendAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}

	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method switches focus to child window if ur windwo/project opens a new window
	 * bunu kullanabilirsin belki hic ihtiyacin da olmayabilir
	 */
	public static void switchToChildWindow() {
		String mainWindowID = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(mainWindowID)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	// kendim
//	public static void waitAndClick() {
//		
//	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForClickability(element);// burda click yapmadan once we're saying to wait before click jsut to make sure
										// finds the element
		element.click();
	}

	// kemdim
//	public static void waitForClickability(List<WebElement> element) {
//		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
//	}
//	//kendim
//	public static void click(List<WebElement> element) {
//		waitForClickability(element);// burda click yapmadan once we're saying to wait before click jsut to make sure finds the element
//		element.click();
//	}

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Method that will scroll th epage down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ");");
	}

	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ";");
	}

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//practiced 	
//	public static void takesSCREENSHOT(String filename) {
//		File file =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//		try {
//			FileUtils.copyFile(file, new File("SCREENSHOT/"+filename+".png"));
//
//		}catch(IOException e) {
//			System.out.println("ss cannot be taken");
//		}
//	}

	// Created a function for screenshot and wanted to share with you all.
//	public static void takesScreenshot(String fileName) {
//		TakesScreenshot ts = (TakesScreenshot) driver;//casting/converting driver to TakesScreenshot 
//		
//		File sourceFile = ts.getScreenshotAs(OutputType.FILE);//(output.file --> saving it into a file
//		try {
//			FileUtils.copyFile(sourceFile, new File("screenshot/"+fileName+".png"));
//		} catch (IOException e) {
////			e.printStackTrace();
//			System.out.println("screeenshot can be taken");
//		}
//	}
	/**
	 * This Method will take a screenshot
	 * 
	 * @param filename
	 */
	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStemp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	
	
	
	
	
	
	
	
	public static String getTimeStemp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}

	// another way for tkesscreenshot
	public static void takesScreenshot(String filename) throws IOException {
		//take ss and store it as a file format
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the ss to desired location using copyFile method
		FileUtils.copyFile(file, new File("/Users/user/eclipse-workspace/TestNG/src"+filename+".png"));
	}
	
//	public static void takesScreenshot(String filepath) {
//		TakesScreenshot ts=(TakesScreenshot) driver;//downcasting
//		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(sourceFile, new File(filepath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

}