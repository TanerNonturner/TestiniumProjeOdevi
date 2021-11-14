package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePageElements;
import utils.CommonMethods;

public class AddEmployeeWithPersonelDetailsSteps extends CommonMethods {

	@When("user enters  employee with {string} and {string}")
	public void user_enters_employee_with_and(String fname, String lname) {
	    sendText(addEmployee.firstName, fname);
	    sendText(addEmployee.lastName, lname);
	}


	@When("click on Personel Details Edit button")
	public void click_on_personel_details_edit_button() {
	   jsClick(personelDetails.buttonEditsave);
	}
	
	@When("I am able to modify Employe Personel Details {string} , {string} , {string}, {string} and {string}")
	public void ý_am_able_to_modify_employe_personel_details_and(String dl, String expDate, String ssn, String gender, String nation) {
	    sendText(personelDetails.driverLicenseNo,dl);
	    sendText(personelDetails.driverLicenceExpirationDate,expDate);
	    sendText(personelDetails.ssn, ssn);
	    
	    if(gender.equals("Male")) {
	    	jsClick(personelDetails.male);
	    }else {
	    	jsClick(personelDetails.female);
	    }
	    
	    selectDropdown(personelDetails.nationality, nation);
	    wait(3);
	    
	    //other way to use calendar pick
	    //input date format 2023-02-08
	    String[] expDateNewFormat = expDate.split("-");
	    int m = Integer.parseInt(expDateNewFormat[1]);//because it use 0(zero)8 but now only 8 it will be ablte to use
	   
	    if(expDateNewFormat[2].charAt(0)=='0') {
	    	
	    	expDateNewFormat[2] = expDateNewFormat[2].replace("0", "");
	    }
	    
	    selectDropdown(personelDetails.year, expDateNewFormat[0]);
	    selectDropdown(personelDetails.month,m);
	   // selectCalenderDate(personelDetails.exprDate,expDateNewFormat[2]);
	}
	
	@Then("click Personel Details Save button")
	public void click_personel_details_save_button() {
		jsClick(personelDetails.buttonEditsave);
	}





}
