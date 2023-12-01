package Day03;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {

	@Test
	public void SingleUserResponseHeader() {	
		RequestSpecification requestSpec = RestAssured.given();
		
		// Base URI
		requestSpec.baseUri("https://reqres.in/");
		
		//Base path
		requestSpec.basePath("/api/users/2");
		
		// get request		
		Response response = requestSpec.get();
		
		// validate response header
		String contentType = response.header("Content-Type");
		//System.out.println("ContentType:"+contentType);
		
		Headers headers = response.getHeaders();  // get All header
		
		for(Header header:headers) {    // iterate header to get all header value
			
			System.out.println("Key:" +header.getName() +"    "+ "value: "+header.getValue());
		}
		
		//validate header content-type
		
		//Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		ValidatableResponse validateResponse = response.then();
		validateResponse.contentType("application/json; charset=utf-8");
	}
}
