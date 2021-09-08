package api_august_tutorial;

import io.restassured.RestAssured;

public class HeaderValidation {
	public static void main(String[] args) {
		String url="https://api.github.com/orgs/{orgName}/repos";
		
		RestAssured
		.given()
		.queryParam("type","public")
		.queryParam("per_page","1")
		.pathParam("orgName","gyanesh4uorg")
		.when()
		.log().all()
		.get(url)
		.then()
		.log().body()
		.assertThat()
		.header("Server","GitHub.com")
		.statusCode(200);
	}
}
