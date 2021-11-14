package steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import practiceAPIUtils.APIConstants;
import practiceAPIUtils.GlobalVariables;

public class GeneratingTokenUtils {
	//I can access token variable from other classes
	public static String token;
	
	@Given("A token is generated")
	public void a_token_is_generated() {
		RestAssured.baseURI = APIConstants.BASE_URI;
		
		String payload ="{\r\n"
				+ "  \"userName\": \"Sonsun\",\r\n"
				+ "  \"password\": \"Sonsun@123\"\r\n"
				+ "}";
	//Retrieving token from response	
	 token = RestAssured.given()
			 	.header("Content-Type", GlobalVariables.contentType)
			 	.body(payload)
			 	.when().post(APIConstants.POST_GENERATE_TOKEN_ENDPOÝNT)
			 	.body()
			 	.jsonPath().getString("token");
		System.out.println(token);
	}
}
