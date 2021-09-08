package api_august_tutorial;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class ResponseBodyValidationArray {

	public static void main(String[] args) {
		String url="https://reqres.in/api/users";
		RestAssured
		.given()
				.queryParam("page",1)
		.when()
				.log().all()
				.get(url)
		.then()
				.log().body()
				.assertThat()
						.statusCode(200)
				.and().assertThat()
						.body("data.size()",Matchers.equalTo(6))
						.body("page",Matchers.equalTo(1))
						.body("data.email[0]", Matchers.equalTo("george.bluth@reqres.in"))
						.body("data.email",Matchers.hasItem("emma.wong@reqres.in"))
						.body("data.first_name",Matchers.contains("George","Janet","Emma","Eve","Charles","Tracey"))
						.body("data.first_name",Matchers.containsInAnyOrder("George","Janet","Emma","Eve","Charles","Tracey"));
	}
}
