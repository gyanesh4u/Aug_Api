package api_august_tutorial;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class CreateGitHubRepo {

	public static void main(String[] args) {
		String url="https://api.github.com/orgs/gyanesh4uorg/repos";
		String inputJson="{\r\n"
				+ "\"name\" : \"srishti\"\r\n"
				+ "}";
		String authToken="Bearer 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";
		
		RestAssured
		.given()
			.header("Authorization",authToken)
			.body(inputJson)
		.when()
			.post(url)
		.then()
			.assertThat()
			.statusCode(201)
			.assertThat()
			.body("name",Matchers.equalTo("srishti"))
			.body("full_name",Matchers.equalTo("gyanesh4uorg/srishti"));
	}
}
