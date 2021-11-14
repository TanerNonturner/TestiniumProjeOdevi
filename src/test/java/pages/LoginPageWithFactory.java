package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPageWithFactory extends CommonMethods {
	
	
	@FindBy(id="txtUsername")
	public WebElement user;

	@FindBy(name ="txtPassword")
	public WebElement password;
	
	@FindBy(css ="input#btnLogin")
	public WebElement loginButton;
	
	@FindBy(id="spanMessage")
	public WebElement errorMessage;
	
	public LoginPageWithFactory() {
		PageFactory.initElements(driver, this);
	}
	
}
