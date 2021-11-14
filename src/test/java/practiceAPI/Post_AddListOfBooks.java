package practiceAPI;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import practiceAPIUtils.APIConstants;
import practiceAPIUtils.GlobalVariables;

import static org.hamcrest.Matchers.*;

public class Post_AddListOfBooks {

	@Test
	public void addListOfBooks() {
		
		String payload ="{\r\n"
				+ "  \"userId\": \"38d29eb8-11bf-493f-b863-9f5b6b2e2db0\",\r\n"
				+ "  \"collectionOfIsbns\": [\r\n"
				+ "    {\r\n"
				+ "      \"isbn\": \""+GlobalVariables.book1+"\"\r\n"
				+ "    }\r\n"
				+ "    ,{\r\n"
				+ "      \"isbn\": \""+GlobalVariables.book2+"\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	
	RestAssured.baseURI= APIConstants.BASE_URI;
	
	RestAssured.given()
				.header("Authorization","Bearer "+GlobalVariables.Token)
				//.auth().oauth2(GlobalVariables.Token)
				.header("Content-Type",GlobalVariables.contentType)
				//.contentType(ContentType.JSON) second way
				.body(payload)
				.when().post(APIConstants.POST_BOOKS_ENDPOÝNT).prettyPeek()
				.then().assertThat().statusCode(201)
				//checking isbn is the same or not
				.body("books[0].isbn", is(GlobalVariables.book1) );
				
	
	
	
	
	}
	
	
}
