package practiceAPI;

import static org.hamcrest.Matchers.is;

import org.junit.Test;

import io.restassured.RestAssured;
import practiceAPIUtils.APIConstants;
import practiceAPIUtils.GlobalVariables;

public class Get_Account {
	
	@Test
	public void getAccount()
	{
		
		RestAssured.baseURI=APIConstants.BASE_URI;
		
		RestAssured.given()
			.header("Authorization","Bearer "+GlobalVariables.Token) //1 way
			//.auth().oauth2(GlobalVariables.Token) // secondway
			.pathParam("UUID", GlobalVariables.UserID)
			.when().get(APIConstants.GET_ACCOUNT_ENDPOÝNT).prettyPeek()
			.then().assertThat().statusCode(200)
			//let's check the size of books
			.body("books.size()", is(2));
	}
}
