package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class DashboardPage extends CommonMethods{
	
	
	public WebElement  OrangeHRMlogo = driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));

}
