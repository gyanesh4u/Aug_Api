package chapter12;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class ReqResRequestSpecExample {

	public static void main(String[] args) {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="api/users";
		String url="{userId}";
		
		RequestSpecBuilder reqBuilder=new RequestSpecBuilder();
		reqBuilder.setContentType(ContentType.JSON);
		reqBuilder.addHeader("Authorization","abc123");
		
		
		
		
		RestAssured
		.given()
		.pathParam("userId",1)
		.when()
		
		.get(url)
		.then()
		.assertThat().statusCode(200);
		
	}
}
