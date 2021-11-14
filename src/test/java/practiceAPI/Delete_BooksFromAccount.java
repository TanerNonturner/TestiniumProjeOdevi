package practiceAPI;

import org.junit.Test;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import practiceAPIUtils.APIConstants;
import practiceAPIUtils.GlobalVariables;

public class Delete_BooksFromAccount {
	
	
	@Test
	public void deleteBooksFromAccount() {
		RestAssured.baseURI=APIConstants.BASE_URI;
		
		RestAssured.given()
				.queryParam("UserId",GlobalVariables.UserID)
				.header("Authorization", "Bearer "+GlobalVariables.Token)
				.when().delete(APIConstants.DELETE_ALLBOOKS_FROM_ACCOUNT)
				.then().assertThat().statusCode(204)
				.and()
				.body("userId", is(GlobalVariables.UserID));
	}

}
