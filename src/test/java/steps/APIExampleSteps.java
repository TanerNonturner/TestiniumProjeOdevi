package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import practiceAPIUtils.APIConstants;
import practiceAPIUtils.GlobalVariables;
import static org.hamcrest.Matchers.*;

public class APIExampleSteps  {
	
	Response getAccountResponse;

	@When("I add a book to the account")
	public void ý_add_a_book_to_the_account() {
		RestAssured.baseURI=APIConstants.BASE_URI;
		
		String payload ="{\r\n"
				+ "  \"userId\": \"2db9b41c-3131-43e8-b3c2-bea30f93268e\",\r\n"
				+ "  \"collectionOfIsbns\": [\r\n"
				+ "    {\r\n"
				+ "      \"isbn\": \"9781449325862\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		
		 RestAssured.given()
			.header("Content-Type", GlobalVariables.contentType)
			.header("Authorization","Bearer "+GeneratingTokenUtils.token)
			.body(payload)
			.when()
			.post(APIConstants.POST_BOOKS_ENDPOÝNT);
					
	}

	@When("I get the account information")
	public void ý_get_the_account_information() {
		RestAssured.baseURI= APIConstants.BASE_URI;
		
		getAccountResponse = RestAssured.given()
			.header("Authorization", "Bearer "+GeneratingTokenUtils.token)
			.pathParam("UUID", "2db9b41c-3131-43e8-b3c2-bea30f93268e")
			.when().get(APIConstants.GET_ACCOUNT_ENDPOÝNT);
		
	}

	@Then("I validate that book is in the account")
	public void ý_validate_that_book_is_in_the_account() {
		getAccountResponse.then().assertThat().body(containsString("9781449325862"));
	}

}
