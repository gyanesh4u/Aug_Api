package com.qa.restassuredtest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ListOfOrg {

	public static void main(String[] args) {
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://api.github.com/organizations");

		Response response = request.get();
		 response.getBody().prettyPrint();
		//System.out.println("Response Details :" + resString);
		ValidatableResponse valRes = response.then();
		valRes.statusCode(200);

	}
}
