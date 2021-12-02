package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
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

import testbases.PageInitializer;

public class CommonMethods extends PageInitializer {
	
	
	/**
	 * This method writes into txt file
	 * @param filepath
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	
	public static void writeTXTfile(String filepath, String key,String value) throws Exception {
		//We want to write to an existing file and add more pairs/entries
		//String filePath ="C:\\Users\\P&B\\eclipse-workspace\\JavaTaner\\src\\lesson32\\configs\\example.properties";
		String filePath= filepath;
	
		
		FileInputStream fis = new FileInputStream(filePath);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		prop.setProperty(key,value);
		
		FileOutputStream fos = new FileOutputStream(filePath);
		
		prop.store(fos, "added a new entry");
	}

	/**
	 * This methods clears text box and send text.
	 * 
	 * @param element
	 * @param text
	 */

	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);
	}

	/**
	 * 
	 * This method checks if radio or check button is enabled and click element that
	 * has the value we want.
	 * 
	 * @param listElement
	 * @param value
	 */

	public static void clickRadioOrCheckBox(List<WebElement> listElement, String value) {

		String actualValue;

		for (WebElement el : listElement) {

			actualValue = el.getAttribute(value).trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}

		}

	}

	// only works at Select tag
	public static void selectDropdown(WebElement element, String textToBeSelected) {

		try {

			Select select = new Select(element);

			List<WebElement> allOptions = select.getOptions();

			for (WebElement el : allOptions) {

				if (el.getText().equals(textToBeSelected)) {
					select.selectByVisibleText(textToBeSelected);
					break;
				}

			}

		} catch (UnexpectedTagNameException e) {

			e.printStackTrace();

		}
	}

	public static void selectDropdown(WebElement element, int index) {
		try {

			Select select = new Select(element);

			int size = select.getOptions().size();
			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method accepts alert and if no alert throws an exception
	 * 
	 * 
	 */
	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}

	}

	public static void dismissAlert() {
		try {

			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

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
	 * This method sends text to the alert if there is not alert catchs exception
	 * (throws NoAlertPresentexception)
	 * 
	 * @param text
	 */
	public static void sendAlertText(String text) {

		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This methods switches to frame by using name or Id
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method switches to frame by using int index
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method switches frame by using WebElement
	 * 
	 * @param element
	 */

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * This method switches to child window
	 * 
	 */
	public static void switchToChildWindow() {

		String mainWindow = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String window : allWindowHandles) {

			if (!window.equals(allWindowHandles)) {

				driver.switchTo().window(window);
			}
		}

	}

	/**
	 * 
	 * This method creates a wait object and returns it.
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);

		return wait;
	}

	/**
	 * This methods waits for an item to be clickable
	 * 
	 * @param element
	 * @return
	 */

	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * This method waits for an element to be visible
	 * 
	 * @param element
	 * @return
	 */

	public static WebElement waitForVisibilty(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method casts driver to JavascriptExecutor and returns it.
	 * 
	 * @return
	 */

	public static JavascriptExecutor getJSObject() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		return js;
	}

	/**
	 * This method will click the element with using JavascriptExecutor.
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {

		getJSObject().executeScript("arguments[0].click()", element);

	}

	/**
	 * This method will scroll the page until the element is visible.
	 * 
	 * @param element
	 */

	public static void scrollToElement(WebElement element) {

		getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void scrollDown(int pixel) {

		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	public static void scrollUp(int pixel) {

		getJSObject().executeScript("window.scollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will select the date from the calendar
	 * 
	 * @param elements
	 * @param date
	 */
	public static void selectCalendarDate(List<WebElement> elements, String date) {
		for (WebElement day : elements) {
			if (day.isEnabled()) {
				if (day.getText().equals(date)) {
					day.click();
					break;
				}
			}
		}
	}

	/**
	 * 
	 * This methods takes screenshot and gives a filename (a name to screenshot )
	 * This methods works with new new File("screenshots\\"+filename+".png") it is
	 * ok
	 * 
	 * @param filename
	 */

	public static String takesScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(sourceFile, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destination;

	}

	public static byte[] CucumberTakesScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
		
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String destination = Constants.CUCUMBER_SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(sourceFile, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return picBytes;

	}

	/**
	 * This method returns current TimeStamp into String format
	 * 
	 * @return
	 */

	public static String getTimeStamp() {

		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_ss");

		return sdf.format(date.getTime());

	}

}
