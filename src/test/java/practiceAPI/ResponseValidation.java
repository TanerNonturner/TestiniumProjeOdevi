package practiceAPI;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseValidation {

	@Test
	public void verifyGetRequest() {
		RestAssured.baseURI="https://demoqa.com/";
		
		RequestSpecification getAllBooksRequest = RestAssured.given();
		
		Response allBooksResponse = getAllBooksRequest.when().get("/BookStore/v1/Books");
		
		allBooksResponse.then().assertThat().statusCode(200);
		
		//Another way to verify status code with junit Assertion
		//int statusCodeActual = allBooksResponse.statusCode();
		//int statusCodeExpected = 500;
		//import org.junit org.Assert not the other one
		//Assert.assertEquals("Status Code is not matching",statusCodeExpected, statusCodeActual);
		allBooksResponse.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
		// Another way
		String contentTypeActual = allBooksResponse.getHeader("Content-Type"); //or allBooksResponse.getContentType();
		String contentTypeExpected="application/json; charset=utf-8";
		System.out.println(contentTypeActual);
		Assert.assertEquals("Content-Type is not matching", contentTypeExpected, contentTypeActual);
		System.out.println("Verifying  if body contains Git Pocket Guide");
		String body =allBooksResponse.getBody().asString();
		Assert.assertTrue("Ýt doesnt contain Git Pocket Guide",body.contains("Git Pocket Guide"));
		
		
	}

}
