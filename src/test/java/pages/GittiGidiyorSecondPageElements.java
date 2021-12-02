package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class GittiGidiyorSecondPageElements extends CommonMethods{
	
	@FindBy(xpath="//*[@id=\"__next\"]/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a/span")
	public WebElement secondButtonText;
	
	@FindBy(xpath="/html/body/div[1]/main/div[2]/div/div/div[2]/div/div[3]/div[3]/ul/li[3]/article/div[2]/a/div")
	public WebElement product;
	

	
	
	public GittiGidiyorSecondPageElements() {
		 PageFactory.initElements(driver,this);
	}

}
