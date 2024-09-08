package session_03_all_methods;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_delete_method {
	@Test
	public void test06() {
		RestAssured.baseURI="https://reqres.in/api/users/209";
		RestAssured.given()
		.when()
			.delete()
		.then()
		.log().all()
		.statusCode(204);
	}

}
