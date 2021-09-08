package api_august_tutorial;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class ResponseBodyValidation {
	/**
	 * Creates a matcher that matches if the examined object matches <b>ALL</b> of the specified matchers.
	 * For example:
	 * <pre>assertThat("myValue", allOf(startsWith("my"), containsString("Val")))</pre>
	 */
	public static void main(String[] args) {
		String url="https://reqres.in/api/users/{userId}";
		RestAssured
		.given()
		.pathParam("userId",2)
		.when()
		.log().all()
		.get(url)
		.then()
		.log().body()
		.assertThat()
		.statusCode(200)
		.assertThat()
		.body("data.id",Matchers.equalTo(2))
		.body("data.email",Matchers.equalTo("janet.weaver@reqres.in"));
		
	}
}
