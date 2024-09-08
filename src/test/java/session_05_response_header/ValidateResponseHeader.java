package session_05_response_header;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	@Test
	public void getSingleUser()
	{
		//get request specification
		RequestSpecification requestSpec= RestAssured.given();
		//specify base uri
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users/2");
		
		//create get request
		Response response = requestSpec.get();
		
		//validate response header
		String contentType = response.header("Content-Type");
		//System.out.println("content type"+contentType);
		
		//read all the response headers and print there values
		Headers headersList = response.headers();
	
		for(Header header:headersList)
		{
			System.out.println("key:"+header.getName()+"  value:"+header.getValue());
		}
		
		Assert.assertEquals(contentType, "application/json; charset=utf-8","headers content missmatch");
	}

}
