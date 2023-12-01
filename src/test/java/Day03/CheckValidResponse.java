package Day03;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckValidResponse {
	@Test(enabled=false)
	public void getSingleUser() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		// Get Request Specification it's interface // used to avoid duplication
		
		RequestSpecification requestSpec = RestAssured.given();
		
		// call get method and store in variable
		Response response = requestSpec.get();
		
		// get response code and store in variable
		int statusCode = response.getStatusCode();
		
		// validate statuscode
		
		Assert.assertEquals(statusCode, 200);
		
		// get status line
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		
		// validate status Line
		
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}
	

	
	@Test
	public void getSingleUserValidatableResponse() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		// Get Request Specification it's interface // used to avoid duplication
		
		RequestSpecification requestSpec = RestAssured.given();
		
		// call get method and store in variable
		Response response = requestSpec.get();
		
		ValidatableResponse  validateResponse= response.then();  // alternate of assert
		
		validateResponse.statusCode(200).log().all();
		validateResponse.statusLine("HTTP/1.1 200 OK").log().all();
	}
	
	
	
	
	@Test
	public void getSingleUserBDDMethod() {		
		RestAssured
		.given()
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200).statusLine("HTTP/1.1 200 OK");
	}
}
