package api_august_tutorial;

import io.restassured.RestAssured;

public class BasicRestAssuredExample {

	public static void main(String[] args) {
		String url="https://api.github.com/orgs/gyanesh4uorg";
		
		//Gherkin language syntax
		//given() Pre condition,what is actually known to us
		//when() Action that is happening [GET,POST,PUT,PATCH,DELETE]
		//then() Validations
		RestAssured
		.given()
		.when()
		.get(url)
		.then()
		.assertThat()
		.statusCode(200);
	}
}
