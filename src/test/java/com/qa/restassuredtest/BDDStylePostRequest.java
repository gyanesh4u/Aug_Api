package com.qa.restassuredtest;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStylePostRequest {

	public static void main(String[] args) {
		String jsonString="{ \"username\" : \"admin\", \"password\" : \"password123\" }";
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.contentType(ContentType.JSON)
		.body(jsonString)
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(200)
		.body("token",Matchers.notNullValue())
		.body("token.length()",Matchers.is(15))
		.body("token",Matchers.matchesRegex("^[a-z0-9]+$"));
	}
}
