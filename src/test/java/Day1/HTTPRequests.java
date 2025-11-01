package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


//given()
// content type, set cookies, add auth, add param, set headers info etc...
 
//when()
//get, post, put, delete

//then()
//validate status code, extract response, extract header cookies & response body


public class HTTPRequests {

	//@Test(priority=1)   
	void getUser() {
		//given()
		when()
			.get("https://reqres.in/api/users?page=2")	
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))//in body if there is 2 then it will pass
			.log().all();	
	}
	
	//@Test(priority=2)
	void createUser() {
		
		HashMap data=new HashMap();
		data.put("name","pavan");
		data.put("job","trainer");
		
		
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
	
	//@Test(priority=3)
	void updateUser() {//put resquest
		
		HashMap data=new HashMap();
		data.put("name","pavan");
		data.put("job","teacher1");
		
		
		given() 
		
			.contentType("application/json")
			.body(data)
			.header("x-api-key", "reqres-free-v1")
			
		.when()
			.put("https://reqres.in/api/users/"+724)
		
		.then()	
			.statusCode(200)
			.log().all();		
	}
	
	@Test
void deleteUser() {//put resquest
		
		HashMap data=new HashMap();
		data.put("name","pavan");
		data.put("job","teacher1");
		
		
		given() 
		
			.contentType("application/json")
			.body(data)
			.header("x-api-key", "reqres-free-v1")
			
		.when()
			.delete("https://reqres.in/api/users/"+724)
		
		.then()	
			.statusCode(204)
			.log().all();		
	}
	
	
	
	
}
