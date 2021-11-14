package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class PersonelDetailsElements extends CommonMethods {
	
	
	@FindBy(xpath ="//*[@id=\"pdMainContainer\"]/div[1]/h1")
	public WebElement personelDetails;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement employeeID;
	
	@FindBy(id="profile-pic")
	public static WebElement profilePic;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement driverLicenseNo;
	
	@FindBy(id="btnSave")
	public WebElement buttonEditsave;
	
	@FindBy(id="personal_txtLicExpDate")
	public WebElement driverLicenceExpirationDate;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement ssn;
	
	@FindBy(id="personal_optGender_1")
	public WebElement male;
	
	@FindBy(id="personal_optGender_1")
	public WebElement female;
	
	@FindBy(id="personal_cmbNation")
	public WebElement nationality;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
	public WebElement month;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
	public WebElement year;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td")
	public List<WebElement> exprDate;
	
	public PersonelDetailsElements() {
		
		PageFactory.initElements(driver, this);
	}
	
}
