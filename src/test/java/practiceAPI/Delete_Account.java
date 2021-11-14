package practiceAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import practiceAPIUtils.APIConstants;
import practiceAPIUtils.GlobalVariables;

public class Delete_Account {
	
	@Test
	public void deleteAccount() {
		RestAssured.baseURI= APIConstants.BASE_URI;
		
		RestAssured.given()
				//.header("Authorization","Bearer "+GlobalVariables.Token)
				.auth().oauth2(GlobalVariables.Token)
				.pathParam("UUID", GlobalVariables.UserID)
				.when().delete(APIConstants.DELETE_ACCOUNT).prettyPeek()
				.then().assertThat().statusCode(200);
	}

}
