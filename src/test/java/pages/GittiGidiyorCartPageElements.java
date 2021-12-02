package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class GittiGidiyorCartPageElements extends CommonMethods {
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[1]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[5]/div/div[2]/strong")
	public WebElement cartPrice;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[1]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select")
	public WebElement selectQuantity;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[1]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[3]/div/div/a/i")
	public WebElement deleteImage;
	
	public GittiGidiyorCartPageElements() {
		PageFactory.initElements(driver, this);
	}

}
