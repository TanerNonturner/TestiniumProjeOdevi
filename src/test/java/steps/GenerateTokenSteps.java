package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import practiceAPIUtils.APIConstants;
import practiceAPIUtils.GlobalVariables;

import static org.hamcrest.Matchers.*;

public class GenerateTokenSteps {

	RequestSpecification request;
	
	Response generateTokenResponse;
	
	@Given("I create a generate token request")
	public void ý_create_a_generate_token_request() {
		RestAssured.baseURI= APIConstants.BASE_URI;
	    request = RestAssured.given();
	}

	@Given("I provide the header and body")
	public void ý_provide_the_header_and_body() {
		request.header("Content-Type",GlobalVariables.contentType );
		String payload ="{\r\n"
				+ "  \"userName\": \"Sonsun\",\r\n"
				+ "  \"password\": \"Sonsun@123\"\r\n"
				+ "}";
		request.body(payload);
	}

	@When("I make a POST call to generate token endpoint")
	public void ý_make_a_post_call_to_generate_token_endpoint() {
		generateTokenResponse=request.when().post(APIConstants.POST_GENERATE_TOKEN_ENDPOÝNT);
	}

	@Then("I validate the status code is {int}")
	public void ý_validate_the_status_code_is(Integer statusCode) {
		generateTokenResponse.then().assertThat().statusCode(statusCode);
	}

	@Then("I validate the body contains {string}")
	public void ý_validate_the_body_contains(String string) {
		generateTokenResponse.then().assertThat().body(containsString("Success"));
	    
	}

	@Then("I validate the {string} is {string}")
	public void ý_validate_the_is(String key, String value) {
		generateTokenResponse.then().assertThat().body(key, equalTo(value));
	}

}
