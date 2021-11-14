package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import practiceAPIUtils.APIConstants;

import static org.hamcrest.Matchers.*;

public class GetOneBookSteps2 {

	RequestSpecification  getOneBookRequest;
	Response response;
	
	@Given("I create get one book request")
	public void ý_create_get_one_book_request() {
		RestAssured.baseURI=APIConstants.BASE_URI;
		getOneBookRequest =RestAssured.given();
	}

	
	@Given("I provide the ISBN number {string} as a query param")
	public void ý_provide_the_ýsbn_number_as_a_query_param(String string) {
		getOneBookRequest.queryParams("ISBN", string );
	}

	@When("I make a get call to get one book endpoint")
	public void ý_make_a_get_call_to_get_one_book_endpoint() {
		response = getOneBookRequest.when().get(APIConstants.GET_ONE_BOOK_ENDPOÝNT);
	}

	@Then("I validate the status code of get one book response is {int}")
	public void ý_validate_the_status_code(int statusCode) {
		response.then().assertThat().statusCode(statusCode);		
	}

	@Then("I validate the response body is {string}")
	public void ý_validate_the_response_body_is(String value ) {
		response.then().assertThat().body(containsString(value));
		}

	@Then("I validate the book title is {string}")
	public void ý_validate_the_book_title_is(String title) {
		response.then().assertThat().body("title", equalTo(title));
		
	}

}
