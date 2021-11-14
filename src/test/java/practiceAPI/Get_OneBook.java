package practiceAPI;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class Get_OneBook {

	@Test
	public void getOneBookTest() {
		
		RestAssured.baseURI="https://demoqa.com";
		
		RequestSpecification getRequest = RestAssured.given();
		//1. way
		getRequest.queryParams("ISBN","9781491904244");
		
		Response getOneBookResponse = getRequest.when().get("/BookStore/v1/Book");
		//  2. way Response getOneBookResponse = getOneBookRequest.when().get("/BookStore/v1/Book?ISBN=9781491904244");
		getOneBookResponse.prettyPrint();
		System.out.println("-------------------");
		System.out.println("Status code is "+getOneBookResponse.statusCode());
		getOneBookResponse.then().assertThat().statusCode(200);
		//Assertion with using hamcrest Matcher equalTo() method
		// we need to import this --- import static org.hamcrest.Matchers.*;
		// first way without importing Matchers
		//getOneBookResponse.then().assertThat().body("title", Matchers.equalTo("You Don't Know JS"));
		//second way with importing Matchers
		getOneBookResponse.then().assertThat().body("title", equalTo("You Don't Know JS"));
		getOneBookResponse.then().assertThat().body("subTitle", containsString("E"));
		getOneBookResponse.then().assertThat().body("author", endsWith("son"));
		
	}
	
}
