package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class GittiGidiyorChosenProductPageElements extends CommonMethods {
	
	
	@FindBy(id="sp-title")
	public WebElement product›nfo;
	
	@FindBy(id="sp-price-lowPrice")
	public WebElement productPrice;
	
	@FindBy(xpath="/html/body/div[3]/div[2]/div/div[6]/div/div[4]/section/div/div/div[2]/form/button")
	public WebElement addCart;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[4]/div[3]")
	public WebElement cartImage;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a")
	public WebElement gotToCart;
	
	public GittiGidiyorChosenProductPageElements() {
		PageFactory.initElements(driver, this);
	}

}
