package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {
	
	
	
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	
	@FindBy(id="employeeId")
	public WebElement employeeId;
	
	
	@FindBy(id="chkLogin")
	public WebElement checkBoxLoginDetails;
	
	@FindBy(id="user_name")
	public WebElement userName;
	
	@FindBy(id="user_password")
	public WebElement password;
	
	@FindBy(id="re_password")
	public WebElement confirmPassword;
	
	
	@FindBy(id="btnSave")
	public WebElement saveButton;
	
	@FindBy(id="middleName")
	public WebElement middleName;
	
	public AddEmployeePageElements() {
		
		PageFactory.initElements(driver, this);
	}

}
