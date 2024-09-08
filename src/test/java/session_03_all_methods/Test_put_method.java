package session_03_all_methods;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_put_method {
	@Test
	public void test04() {
		JSONObject jsonData =new JSONObject();
		jsonData.put("name", "Malhar");
		jsonData.put("job", "Student");
		
		RestAssured.baseURI="https://reqres.in/api/users/209";
		RestAssured.given().header("Content-type","application/json")
		.contentType(ContentType.JSON)
		.body(jsonData.toJSONString())
		.when().put().
		then().statusCode(200).log().all();
	}
	

}
