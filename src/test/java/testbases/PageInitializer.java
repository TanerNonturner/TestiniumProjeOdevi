package testbases;

import pages.AddEmployeePageElements;
import pages.DashboardPageWithFactory;
import pages.EmployeeListPageElements;
import pages.GittiGidiyorCartPageElements;
import pages.GittiGidiyorCartisEmptyPageElements;
import pages.GittiGidiyorChosenProductPageElements;
import pages.GittiGidiyorMainPageElements;
import pages.GittiGidiyorResultSearchPageElements;
import pages.GittiGidiyorSecondPageElements;
import pages.LoginPageWithFactory;
import pages.PersonelDetailsElements;

public class PageInitializer extends BaseClass {
	// ý don not initialize (give value) all the time page element classes because of this ý do this.
	// ý create class not object with static
	public static LoginPageWithFactory login;
	public static DashboardPageWithFactory dashboard;
	public static AddEmployeePageElements addEmployee;
	public static PersonelDetailsElements personelDetails;
	public static EmployeeListPageElements employeeList;
	public static GittiGidiyorMainPageElements gittiGidiyorMain;
	public static GittiGidiyorResultSearchPageElements gittiGidiyorResult;
	public static GittiGidiyorSecondPageElements gittiGidiyorSecond;
	public static GittiGidiyorChosenProductPageElements gittiGidiyorChosen;
	public static GittiGidiyorCartPageElements gittiGidiyorCart;
	public static GittiGidiyorCartisEmptyPageElements gittiGidiyorCartEmpty;
	
	//we always initialize when new driver created!!
	public static void initialize() {
		login = new LoginPageWithFactory();
		dashboard = new DashboardPageWithFactory();
		addEmployee = new AddEmployeePageElements();
		personelDetails = new PersonelDetailsElements();
		employeeList = new EmployeeListPageElements();
		gittiGidiyorMain= new GittiGidiyorMainPageElements();
		gittiGidiyorResult = new GittiGidiyorResultSearchPageElements();
		gittiGidiyorSecond = new GittiGidiyorSecondPageElements();
		gittiGidiyorChosen = new GittiGidiyorChosenProductPageElements();
		gittiGidiyorCart = new GittiGidiyorCartPageElements();
		gittiGidiyorCartEmpty = new GittiGidiyorCartisEmptyPageElements();
	}
}
