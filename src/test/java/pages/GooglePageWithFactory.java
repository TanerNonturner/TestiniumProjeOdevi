package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class GooglePageWithFactory extends CommonMethods {
	
	
	@FindBy(xpath="//input[@name='q']")
	public static WebElement searhBox;
	
	public void GooglePageFactory() {
		 
		PageFactory.initElements(driver,this);
	}
	

}
