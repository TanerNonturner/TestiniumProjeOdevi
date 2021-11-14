package steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ExcelUtility;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user navigates Add Employee Page")
	public void user_navigates_add_employee_page() {
		jsClick(dashboard.PIM);
		jsClick(dashboard.addEmp);
	}

	// parameterized steps
	@When("user enters {string} and last name {string}")
	public void user_enters_and_last_name(String firstname, String lastname) {
		sendText(addEmployee.firstName, firstname);
		sendText(addEmployee.lastName, lastname);
	}

	// passing hard-coded parameters example
	@When("user enters firts name and last name")
	public void user_enters_firts_name_and_last_name() {
		sendText(addEmployee.firstName, "Tanerdi");
		sendText(addEmployee.lastName, "Messi");
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
		jsClick(addEmployee.saveButton);
	}

	@When("user enters {string} , {string} and {string}")
	public void user_enters_and(String firstname, String middlename, String lastname) {
		sendText(addEmployee.firstName, firstname);
		sendText(addEmployee.middleName, middlename);
		sendText(addEmployee.lastName, lastname);
	}

	@When("user enters employee details and clicks on save button then employee is added")
	public void user_enters_employee_details_and_clicks_on_save_button_then_employee_is_added(DataTable  table) {
	   
		List<Map<String, String>> employeeList = table.asMaps();
		
		for(Map<String, String> map:employeeList) {
			//first save data on Strings
		
			String fname = map.get("firstname");
			String mname = map.get("middlename");
			String lname = map.get("lastname");
			wait(2);
			sendText(addEmployee.firstName,fname);
			sendText(addEmployee.middleName,mname);
			sendText(addEmployee.lastName,lname);
			wait(1);
			jsClick(addEmployee.saveButton);
			wait(2);
			String expectedText =fname+" "+mname+" "+lname;
			String actualText= personelDetails.profilePic.getText();
			Assert.assertEquals("Employe is not added!",expectedText,actualText);
			
			
			
		}

	
	}

	@Then("user checks  new employee  credentials {string}, {string} and {string}")
	public void user_checks_new_employee_credentials_and(String firstname, String middlename, String lastname) {
		String expectedText = firstname + " " + middlename + " " + lastname;
		String actualText = personelDetails.profilePic.getText();

		Assert.assertEquals("Employee credentials are not true!", expectedText, actualText);
	}

	@Then("employee {string} is added successfully")
	public void employee_is_added_successfully(String name) {
		String expectedText = name;
		String actualText = personelDetails.profilePic.getText();
		Assert.assertEquals("The name is not correct!!", expectedText, actualText);
	}

	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
		String expectedText = "Tanerdi Messi";
		String actualText = personelDetails.profilePic.getText();
		Assert.assertEquals("The name is not correct!!", expectedText, actualText);
	}

	@Then("user deletes Employee ID")
	public void user_deletes_Employee_ID() {
		addEmployee.employeeId.clear();
	}

	@Then("user clicks on Create Login Details")
	public void user_clicks_on_Create_Login_Details() {

		jsClick(addEmployee.checkBoxLoginDetails);

	}

	@Then("user provides credential information")
	public void user_provides_credential_information() {
		sendText(addEmployee.userName, "LineleMessine");
		sendText(addEmployee.password, "1234567890");
		sendText(addEmployee.confirmPassword, "1234567890");
		jsClick(addEmployee.saveButton);
	}

	@When("user enters employee  from {string} excel sheet than employee is added")
	public void user_enters_employee_from_excel_sheet_than_employee_is_added(String sheetName) {
	    // We want to get data from Excel in List of maps format
	
	List<Map<String,String>> excellist = ExcelUtility.excelIntoListOfMaps("C:\\Users\\P&B\\eclipse-workspace\\Cucumber-Framework\\src\\test\\resources\\testdata\\TestExcel.xlsx", sheetName);
	
	for(Map<String,String>data:excellist) {
		
		String fname = data.get("FirstName");
		String lname = data.get("LastName");
		String username = data.get("UserName");
		String password = data.get("Password");
		
		sendText(addEmployee.firstName,fname);
		sendText(addEmployee.lastName,lname);
		jsClick(addEmployee.checkBoxLoginDetails);
		sendText(addEmployee.userName,username);
		sendText(addEmployee.password,password);
		sendText(addEmployee.confirmPassword,password);
		jsClick(addEmployee.saveButton);
		//Assert
		String actualText = personelDetails.profilePic.getText();
		String expectedText = fname+" "+lname;
		 
		Assert.assertEquals("Employe is not added",expectedText,actualText);
		
		wait(1);
		jsClick(dashboard.PIM);
		jsClick(dashboard.addEmp);
	}
	
	
	}
	
	
	
}
