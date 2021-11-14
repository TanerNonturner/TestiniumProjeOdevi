package testbases;

import pages.AddEmployeePageElements;
import pages.DashboardPageWithFactory;
import pages.EmployeeListPageElements;
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
	
	
	//we always initialize when new driver created!!
	public static void initialize() {
		login = new LoginPageWithFactory();
		dashboard = new DashboardPageWithFactory();
		addEmployee = new AddEmployeePageElements();
		personelDetails = new PersonelDetailsElements();
		employeeList = new EmployeeListPageElements();
	}
}
