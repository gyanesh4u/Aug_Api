package api_august_tutorial;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class UpdateGitHubRepo {

	public static void main(String[] args) {
		
		String url="https://api.github.com/repos/gyanesh4uorg/srishti";
		String inputJson="{\r\n"
				+ "    \"description\": \"Patch Request\",\r\n"
				+ "    \"private\": true\r\n"
				+ "}";
		String authToken="Bearer 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";
		
		RestAssured
		.given()
			.header("Authorization",authToken)
			.body(inputJson)
		.when()
			.log().all()
			.patch(url)
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.assertThat()
			.body("description",Matchers.equalTo("Patch Request"))
			.body("private", Matchers.equalTo(true));
	}
}
