package session_04_statusLine_statusCode;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	@Test(enabled=false)
	public void GetSingleUser() {
		//specify base url
		baseURI="https://reqres.in/api/users/2"; 
		
		//get request specification of the request
		RequestSpecification requestSpec = given();
		
		//call get method
		Response response = requestSpec.get();
		
		//gets response code
		int statusCode = response.getStatusCode();
		
		
		//validate actual status code with expected
		
		Assert.assertEquals(statusCode/*actual status*/, 200/*expected*/,"expected response code not received");
		
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	@Test
	public void GetSingleUserValidableResponse() {
		//specify base url
		baseURI="https://reqres.in/api/users/2";
		
		//get request specification of the request
		RequestSpecification requestSpec = given();
		
		//call get method
		Response response = requestSpec.get();
		
		ValidatableResponse validateRes = response.then();
		
		validateRes.statusCode(200);
		System.out.println("second validation");
		validateRes.statusLine("HTTP/1.1 200 OK");
	}
	@Test
	public void GetSingleUserUsingBDD() {
		
		given()
		.when().get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK");
		
	}



}
