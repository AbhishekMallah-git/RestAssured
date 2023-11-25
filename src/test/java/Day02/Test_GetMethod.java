package Day02;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;  // added static keyword to avoid using of 
//RestAssurd everytime
import io.restassured.response.Response;

public class Test_GetMethod {
	@Test
	public void test1() {
		Response res = get("https://reqres.in/api/users?page=2");
		System.out.println("\nResponse code:"+res.getStatusCode()+
				"\n Response Body:"+res.getBody().asString()+
				"\n Response time:"+res.getTime()+
				"\n Response Header:"+res.getHeader("Content-Type"));

		// validate status code expected = 200

		int statusCode = res.getStatusCode();
		int Expected = 200;
		Assert.assertEquals(Expected, statusCode);
	}
	@Test
	public void test2() {
		// given , when , then
		baseURI="https://reqres.in/api/users";
		given()
		.queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
	}
}
