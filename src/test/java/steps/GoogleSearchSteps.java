package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	
	@Given("I navigated to google.")
	public void iNavigateToGoogle() {
		System.out.println("I opened the google");
	}
	@Given("I type a search item in search box.")
	public void ý_type_a_search_item_in_search_box() {
	   System.out.println("I typed searh box");
	}

	@When("I clicked on SearchButton.")
	public void ý_clicked_on_search_button() {
	    System.out.println("I clicked on search button");
	}

	@Then("I see my resolut of search.")
	public void ý_see_my_resolut_of_search() {
	    System.out.println("I validate the results");
	}

	@Then("I see number of the search.")//at feature file  this is Add but the same with Then with purpose because of this it is used Then!!
	public void ý_see_number_of_the_search() {
	    System.out.println("I see the number of result");
	}
	
	
}
