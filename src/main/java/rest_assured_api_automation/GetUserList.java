package rest_assured_api_automation;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserList {
	public class UserList {
	    int id;
		
		@Test(priority=1)
		void getUsers()
		{
			Response response =  given()
			
			.when()
				.get("https://reqres.in/api/users?page=2")
				
					
			.then()
				.statusCode(200)
				.body("page",equalTo(2))
				
				.extract().response();

			//To Print StatusCode
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: " + statusCode);
			
			//To Print JSON response
			System.out.println("JSON Response:");
			response.then().log().body();
			
		    //To Print plain text response
	        System.out.println("Plain Text Response:");
	        System.out.println(response.asString());
		}
	}

}
