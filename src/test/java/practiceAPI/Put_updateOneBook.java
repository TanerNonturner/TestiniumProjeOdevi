package practiceAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import practiceAPIUtils.APIConstants;
import practiceAPIUtils.GlobalVariables;

public class Put_updateOneBook {
	
	@Test
	public void updateOneBook() {
		RestAssured.baseURI=APIConstants.BASE_URI;
		
		String payload ="{\r\n"
				+ "  \"userId\": \""+GlobalVariables.UserID+"\",\r\n"
				+ "  \"isbn\": \""+GlobalVariables.book3+"\"\r\n"
				+ "}";
		
		RestAssured.given()
				.auth().oauth2(GlobalVariables.Token)
				.pathParam("ISBN",  GlobalVariables.book1)
				.body(payload)
				.contentType(ContentType.JSON)
				.when().put(APIConstants.PUT_BOOKS_ENDPOÝNT).prettyPeek()
				.then().assertThat().statusCode(200);
	}

}
