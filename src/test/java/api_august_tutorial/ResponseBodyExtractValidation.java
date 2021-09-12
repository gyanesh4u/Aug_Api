package api_august_tutorial;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ResponseBodyExtractValidation {
	public static void main(String[] args) {
		String url="https://api.github.com/orgs/gyanesh4uorg/repos?per_page=2";
		JsonPath resp = RestAssured
		.given()
	
		.when()
		.log().all()
		.get(url)
		.then()
		.extract().response().body().jsonPath();
		String repoName = resp.get("name[0]");
		System.out.println(repoName);
		MatcherAssert.assertThat(repoName,Matchers.equalTo("New-Repo"));
}
}