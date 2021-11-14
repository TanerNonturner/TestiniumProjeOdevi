package practiceAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import practiceAPIUtils.APIConstants;

public class Post_GenerateToken {
	
	@Test
	public void generateToken() {
		
		String payload ="{\r\n"
				+ "  \"userName\": \"Kantzu\",\r\n"
				+ "  \"password\": \"Kantzu@123\"\r\n"
				+ "} ";
		
		RestAssured.baseURI=APIConstants.BASE_URI;
		
		Response generateTokenResponse=
		RestAssured.given()
			.header("Content-Type","application/json")
			.body(payload)
			.when().post("/Account/v1/GenerateToken"); //prettyPeek();
		
		//generateTokenResponse.then().assertThat().statusCode(200);
		System.out.println("Headers are ;  "+generateTokenResponse.headers());
		System.out.println("--------");
		System.out.println("Body is ;");
		//System.out.println(generateTokenResponse.body()); it shows on consoleio.restassured.internal.RestAssuredResponseImpl@3fbcfe81
		System.out.println("Connection of header is "+generateTokenResponse.getHeader("Connection"));
		//headers always in string mode but body only body is not string mode only hard coding mode as above example
		String token = generateTokenResponse.body().jsonPath().getString("token");
		//to print the body do only generateTokenResponse.prettyPrint(); or.prettyPeek();
		//jsonPath we use only to get keys value from body . jsonPath gives a  json path and you can get String,int, boolean ,object etc...
		System.out.println("------------");
		System.out.println("Toke equals to   "+token);
		System.out.println("---------");
		
		}

}
