package Day01;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {
//https://reqres.in/api/users/2	
	@Test
	void testOne() {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println("Status Code:" + res.getStatusCode());
		res.prettyPrint();
		}
}
