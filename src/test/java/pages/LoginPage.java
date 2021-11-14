package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class LoginPage extends CommonMethods{

	
		//no main method
		//public visible in every where 
		//This page classes jobs are to find element at the same page not testing
		public WebElement user= driver.findElement(By.id("txtUsername"));
		
		public WebElement password = driver.findElement(By.id("txtPassword"));

		public WebElement loginButton = driver.findElement(By.id("btnLogin"));
		
		
}
