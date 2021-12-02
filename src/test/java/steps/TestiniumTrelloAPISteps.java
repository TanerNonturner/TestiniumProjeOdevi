package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestiniumTrelloAPISteps {
	@Given("create one board request")
	public void create_one_board_request() {
		
		
		//RestAssured.baseURI = "https://api.trello.com";
		
		 String baseUr ="https://api.trello.com";
	        
	     RequestSpecification rs=   RestAssured.given().baseUri(baseUr)
	 
	        .queryParam("key", "d940e7183030f1bfbc3550828a963a1b")
	        .queryParam("token", "61a6e913e4ef54ed3057a0edf910ac1ee09b855c05413491ac50bec10ac67644");
	     
	     
	        
	       RestAssured.given().spec(rs).when().get("members/me").prettyPrint();
		
		
		
}

	@Given("in that board creat two card")
	public void in_that_board_creat_two_card() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("one of the card is updated")
	public void one_of_the_card_is_updated() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("delete the cards")
	public void delete_the_cards() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("delete the board")
	public void delete_the_board() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
