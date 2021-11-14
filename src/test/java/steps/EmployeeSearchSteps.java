package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigsReader;

public class EmployeeSearchSteps extends CommonMethods {
	
	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
	   
	   wait(2);
	   sendText(login.user,ConfigsReader.getProperty("user"));
	   sendText(login.password,ConfigsReader.getProperty("password"));
	   click(login.loginButton);
	}

	@Given("user navigates to employee list page")
	public void user_navigates_to_employee_list_page() {
	    jsClick(dashboard.PIM);
	    jsClick(dashboard.emplolyeeList);
	}
	@When("user enter valid employee ID")
	public void user_enter_valid_employee_ýd() {
	    sendText(employeeList.employeeID,"0016");
	}
	@When("clicks on search button")
	public void clicks_on_search_button() {
	    jsClick(employeeList.searcBtn);
	}
	
	@When("user enter valid employee first and last name")
	public void user_enter_valid_employee_first_and_lastname() {
		sendText(employeeList.employeeName, "Mary Ann");
		}
	
	
	
	@Then("employee information is displayed")
	public void employee_information_is_displayed() {
	  System.out.println("Employee is displayed");
	  wait(2);
	  
	}




}
