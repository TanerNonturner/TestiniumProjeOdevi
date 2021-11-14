package practiceAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT_CreateAccount {

	//@Test
	public void createAccountTest() {
		RestAssured.baseURI = "https://demoqa.com";
		//I am creating a request
		RequestSpecification request = RestAssured.given();
		
		//continue adding information to request
		//payload = body
		
		String payload ="{\r\n"
				+ "    \"userName\": \"donki\",\r\n"
				+ "    \"password\": \"Donki@123\"\r\n"
				+ "}";
		
		System.out.println(payload);
		// continue adding information to header
		request.header("Content-Type", "application/json");
		//continue adding informantion to body
		request.body(payload);
		
		// I will make a post requestfdf
		
		Response postRequestCreateAccountResponse = request.when().post("/Account/v1/User");
		
		
		postRequestCreateAccountResponse.prettyPrint();
		System.out.println(postRequestCreateAccountResponse.statusCode());
		//postRequestCreateAccountResponse.then().assertThat().statusCode(200);
		System.out.println("--------------");
		//to get full informatin of Status code
		System.out.println(postRequestCreateAccountResponse.getStatusLine());
		
		
		
	}
	
	
	@Test
	public void createAccounTestShortWay() {
		//to print "Taner" we must use in " " this--\"Taner\" ,thus we must write String str ="\"Taner\"";
		String str ="\"Taner\"";
		System.out.println(str);
		RestAssured.baseURI="https://demoqa.com";
		
		String payload ="{\r\n"
				+ "    \"userName\": \"ponki\",\r\n"
				+ "    \"password\": \"Ponki@123\"\r\n"
				+ "}";
		
		
		RestAssured.given()
			.header("Content-Type","application/json")
			.body(payload)
			.when().post("/Account/v1/User")
			.prettyPrint();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}