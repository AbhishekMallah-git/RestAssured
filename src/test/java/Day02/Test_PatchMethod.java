package Day02;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PatchMethod {
	@Test
	public void test1() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Acer");
		jsonData.put("job", "Mgr");
		
		baseURI="https://reqres.in/api/users/577";
		given().header("Content-type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when().patch()
		.then().statusCode(200).log().all();
	}
}
