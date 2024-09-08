package session_03_all_methods;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_patch_method {
	@Test
	public void test05() {
		JSONObject jsonData =new JSONObject();
		jsonData.put("name", "Malhar");
		jsonData.put("job", "baby");
		
		RestAssured.baseURI="https://reqres.in/api/users/209";
		RestAssured.given()
						.header("Content-type","application/json")
						.contentType(ContentType.JSON)
						.body(jsonData.toJSONString())
		.when()
				.patch()
		.then()
				.statusCode(200).log().all();
		
	}

}
