package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PracticeHTTPRequest{
	@Test(priority=1)
	public void getUser() {
		
		given()
		.header("x-api-key", "reqres-free-v1")
		
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
			
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
		
		
	}
	@Test(priority=2)
public void createUser() {
	
		HashMap data=new HashMap();//id 340
		data.put("name", "vaibhav");
		data.put("age", "30");
		
				
		given()
		.contentType("application/json")
		.body(data)
		.header("x-api-key", "reqres-free-v1")
		
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().all();		
}
}
