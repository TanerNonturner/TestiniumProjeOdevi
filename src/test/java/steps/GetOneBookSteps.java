package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import practiceAPIUtils.APIConstants;
//import static means ý can only import methods and variables inside class 
import static org.hamcrest.Matchers.*;

public class GetOneBookSteps {
	//getOneBookRequest can be seen every method everywhere
	RequestSpecification getOneBookRequest;
	//I declare variable here getOneBookRequest
	Response getOneBookResponse;
	
	@Given("I create a request")
	public void ý_create_a_request() {
		RestAssured.baseURI=APIConstants.BASE_URI;
		//initialize variable getOneBookRequest
		getOneBookRequest= RestAssured.given();
	}

	@Given("I provide the ISBN {string} as a query parameter for the request")
	public void ý_provide_the_ýsbn_as_a_query_parameter_for_the_request(String isbn) {
	
		getOneBookRequest.queryParam("ISBN", isbn);
	}

	@When("I make a Get call to the get one book endpoint")
	public void ý_make_a_get_call_to_the_get_one_book_endpoint() {
		getOneBookResponse = getOneBookRequest.when().get(APIConstants.GET_ONE_BOOK_ENDPOÝNT);
	}

	@Then("I validate  that status code for get one book  is {int}")
	public void ý_validate_that_status_code_for_get_one_book_is(Integer statusCode) {
		getOneBookResponse.then().assertThat().statusCode(statusCode);
	}

	@Then("I validate the ISBN at response body is the same with {string}")
	public void ý_validate_the_ýsbn_at_response_body_is_the_same_with(String isbn) {
		getOneBookResponse.then().assertThat().body("isbn",equalTo(isbn));
	}

	@Then("I validate book title is {string}")
	public void ý_validate_book_title_is(String title) {
		getOneBookResponse.then().assertThat().body("title", equalTo(title));
	}

}
