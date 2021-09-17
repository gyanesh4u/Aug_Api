package chapter12;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;

public class ReqResResponseSpecExample {

	public static void main(String[] args) {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="api/users";
		String url="{userId}";
		
		ResponseSpecBuilder respBuilder=new ResponseSpecBuilder();
		respBuilder.expectHeader("Content-Type","application/json; charset=utf-8");
		respBuilder.expectHeader("Server","cloudflare");
		respBuilder.expectStatusCode(200);
		RestAssured.responseSpecification=respBuilder.build();
		RestAssured
			.given()
				.pathParam("userId",1)
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all();
	}
}
