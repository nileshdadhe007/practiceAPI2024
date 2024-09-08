package session_06_validate_res_body;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJSONResponseBody {
	@Test
	public void userResponseBody() {
		//get requestSpecifivation reference
		RequestSpecification requestSpec = RestAssured.given();
		
		//specify base uri and base path
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users?page=1");
		
		//create get request
		Response response = requestSpec.get();
		
		//read response body
		ResponseBody responseBody = response.getBody();
		
		/*String responseString = responseBody.asString();
		
		System.out.println("response body: "+responseString);
		
		//check for presense of george in response body
		//Assert.assertTrue(responseString.contains("George"));
		Assert.assertEquals(responseString.contains("George"), true,"check of george presence");*/
		
		//get json path view of response body
		JsonPath jsonPathView = responseBody.jsonPath(); 
		System.out.println("link"+jsonPathView.get("data[3].avatar"));

		
		String firstName = jsonPathView.get("data[0].first_name");
		Assert.assertEquals(firstName, "George","check for presense of firstname as george");
		
		
	}

}
