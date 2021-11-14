package practiceAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import practiceAPIUtils.APIConstants;

public class Post_CreateNewUser {
	
	@Test
	public void createNewUser() {
		
		String payload ="{\r\n"
				+ "  \"userName\": \"Kantzu\",\r\n"
				+ "  \"password\": \"Kantzu@123\"\r\n"
				+ "} ";
		
		RestAssured.baseURI="https://demoqa.com";
		
		
		RestAssured.given()
			.header("Content-Type","application/json")
			.body(payload)
			.when().post(APIConstants.CREATE_ACCOUNT_ENDPOÝNT).prettyPeek()//preettyPeek() prints console and continues to execute code
			.then().assertThat()
			.statusCode(201);
		
		
				
		
	}

}
