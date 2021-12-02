package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class GittiGidiyorMainPageElements extends CommonMethods{
	
	@FindBy(name="k")
	public WebElement searchBlank;
	
	@FindBy(xpath="/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button/span")
	public WebElement searchButton;
	
	public GittiGidiyorMainPageElements() {
		PageFactory.initElements(driver, this);
	}

}
