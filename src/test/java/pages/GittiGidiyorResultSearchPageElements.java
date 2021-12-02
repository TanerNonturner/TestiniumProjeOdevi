package pages;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import utils.CommonMethods;

public class GittiGidiyorResultSearchPageElements extends CommonMethods {
	
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a/span")
	public WebElement secondButton;
	
	public GittiGidiyorResultSearchPageElements(){
		
		PageFactory.initElements(driver, this);		
	}

}
