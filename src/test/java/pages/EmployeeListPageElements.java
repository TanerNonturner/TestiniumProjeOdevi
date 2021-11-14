package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class EmployeeListPageElements extends CommonMethods {
	@FindBy(id="empsearch_id")
	public WebElement employeeID;
	
	@FindBy(id="searchBtn")
	public WebElement searcBtn;
	
	@FindBy(className="odd")
	public WebElement displayMessage;
	
	@FindBy(name="empsearch[employee_name][empName]")
	public WebElement employeeName;
	
	
	
	public EmployeeListPageElements() {
		
		PageFactory.initElements(driver,this);
	}

}
