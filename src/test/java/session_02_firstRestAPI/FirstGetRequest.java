package session_02_firstRestAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {
	@Test
	void tecase01()
	{
			Response res = RestAssured.get("https://reqres.in/api/users/2");
			System.out.println(res.asString());
			System.out.println("status code: "+res.getStatusCode());
			
			//validate response
	}

}
