package rest_assured_api_automation;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import java.util.HashMap;

public class PostUser {
	@Test
    void CreateUser()
	{
		HashMap h= new HashMap();
		h.put("name", "morpheus");
		h.put("job", "leader");
		
        Response response = (Response) given()
				.contentType("application/json")
				.body(h)
				
				.when()
					.post("https://reqres.in/api/users")
					
						
				.then()
					.statusCode(201)
					.extract().response();

               //Print StatusCode
				int statusCode = response.getStatusCode();
				System.out.println("Status Code: " + statusCode);
				
				// Print JSON response
				System.out.println("JSON Response:");
				response.then().log().body();
					
		        // Print the plain text response
		        System.out.println("Plain Text Response:");
		        System.out.println(response.asString());
	}

}
