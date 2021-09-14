package api_august_tutorial;

import io.restassured.RestAssured;

public class DeleteGithub {

	public static void main(String[] args) {
		String url="https://api.github.com/repos/gyanesh4uorg/srishti";
		
		String authToken="Bearer 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";
		
		RestAssured
		.given()
			.header("Authorization",authToken)
		.when()
			.delete(url)
		.then()
			.assertThat()
				.statusCode(204);
	}
}
