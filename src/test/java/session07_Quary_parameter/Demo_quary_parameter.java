package session07_Quary_parameter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Demo_quary_parameter {
@Test
	public void filterdata() {
	RequestSpecification reqSpec = RestAssured.given();
	reqSpec.baseUri("https://reqres.in");
	reqSpec.basePath("/api/users");
	reqSpec.queryParams("page",2);
	
	//perform get request
		
		
	}
}
