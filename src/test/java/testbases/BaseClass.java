package testbases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigsReader;
import utils.Constants;

public class BaseClass {
	
	public static WebDriver driver;
	
	/**
	 * This method creates a driver and returns it
	 * 
	 * @return WebDriver driver
	 */
	
	public static WebDriver setUp() {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		
		
		switch(ConfigsReader.getProperty("browser").toLowerCase()) {
		case"chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRÝVER_FILEPATH);
			driver = new ChromeDriver();
			break;
		case"firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRÝVER_FILEPATH);
			driver= new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser not supported");
			
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
		
		//We initialize all the the page elements 
		PageInitializer.initialize();
		
		return driver;
		
	}

	/**
	 * This method quits the browser.
	 * 
	 */
	
	public static void tearDown() {
		if(driver!=null) {
			driver.quit();
			
		}
		
		
	}
	
}
