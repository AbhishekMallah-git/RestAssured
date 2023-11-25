package Day02;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Test_DeleteMethod {
	@Test
	public void test01() {
		baseURI="https://reqres.in/api/users/577";
		given()
		.when()
		     .delete()
		.then()
		     .statusCode(204)
		     .log().all();
	}
}
