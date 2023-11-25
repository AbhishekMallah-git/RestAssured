package Day02;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test_PutMethod {
@Test
public void test1() {
	JSONObject jsonData = new JSONObject();
	jsonData.put("name", "Abc2");
	jsonData.put("job", "Dev");
	
	baseURI="https://reqres.in/api/users/577";
	given().header("Content-type","application/json")
	.contentType(ContentType.JSON)
	.body(jsonData.toJSONString())
	.when().put()
	.then().statusCode(200).log().all();
}
}
