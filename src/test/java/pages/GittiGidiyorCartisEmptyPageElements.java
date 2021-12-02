package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class GittiGidiyorCartisEmptyPageElements extends CommonMethods {
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div[2]/h2")
	public WebElement cartEmptyMessage;
	
	public GittiGidiyorCartisEmptyPageElements () {
		
		PageFactory.initElements(driver,this);
	}
	
	

}
