package session_03_all_methods;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class test_getMethod {
	@Test
	public void test01()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("response code: "+response.getStatusCode());
		System.out.println("response body: "+response.body().asString());
		System.out.println("response time in miliseconds: "+response.getTime());
		System.out.println("response header: "+response.getHeader("Content-Type"));
		
		//validate response
		int actStatusCode=response.getStatusCode();
		int expStatusCode=200;
		Assert.assertEquals(expStatusCode, actStatusCode);
	}
	@Test
	public void test02()
	{
		// given when then
		baseURI="https://reqres.in/api/users";
		given().queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
	}
	

}
