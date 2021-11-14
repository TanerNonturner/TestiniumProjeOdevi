package practiceAPI;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get_AllBooks {

	public static void main(String[] args) {
		//default value of baseURI localhost
		RestAssured.baseURI="https://demoqa.com";
		
		System.out.println(RestAssured.baseURI);
		
		RequestSpecification getAllBooksRequest = RestAssured.given();
		//Now we are making an actual request and getting response
		Response allBooksResponse =  getAllBooksRequest.when().get("/BookStore/v1/Books");
		
		//RestAssured.given().when().get("/BookStore/v1/Books");
		//Let's get some information from response object
		int statusCode = allBooksResponse.getStatusCode(); // or allBooksResponse.statusCode(); both are the same
		System.out.println(statusCode);
		System.out.println("-----------");
		Headers headers = allBooksResponse.headers();
		System.out.println("Headers are ;"+headers);
		//Only get specific key in headers
		String contentType = allBooksResponse.getHeader("Content-Type");
		System.out.println("------------");
		System.out.println(contentType);
		
		System.out.println("---Response body as a string-----");
		ResponseBody body = allBooksResponse.getBody();
		System.out.println(body.asString());
		//To get response in a beatiful format , pretty format
		System.out.println("----Response body as a pretty format----");
		allBooksResponse.prettyPrint();  // body.prettyPrint(); this also gives response in pretty format, the same thing.
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
