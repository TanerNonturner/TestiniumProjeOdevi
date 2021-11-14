package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class DashboardPageWithFactory extends CommonMethods {

	@FindBy(xpath="//img[@alt='OrangeHRM']")
	public WebElement OrangeHRMlogo;
	
	@FindBy(id="welcome")
	public WebElement welcomeMessage;
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement PIM;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement emplolyeeList;
	
	@FindBy(xpath="//div[@id='welcome-menu']/ul/li[3]/a")
	public WebElement logout;
	
	@FindBy(xpath="//ul[@id='mainMenuFirstLevelUnorderedList']/li/a")
	public List<WebElement> dashboardMenu;
	
	
	
	public DashboardPageWithFactory() {
		
		PageFactory.initElements(driver, this);
	}
}
