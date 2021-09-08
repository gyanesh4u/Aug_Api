package api_august_tutorial;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class GitHubResponseBodyValidation {

	public static void main(String[] args) {
		String url="https://api.github.com/orgs/gyanesh4uorg/repos?per_page=2";
		RestAssured
		.given()
		.when()
		.log().all()
		.get(url)
		.then()
		.log().body()
		.body("size()", Matchers.equalTo(2))
		.body("id",Matchers.hasItem(397802587))
		.body("full_name",Matchers.hasItem("gyanesh4uorg/New-Repo"))
		.body("owner.login",Matchers.hasItem("gyanesh4uorg"))
		.body("git_url",Matchers.hasItem("git://github.com/gyanesh4uorg/repo_123.git"));
	}
}
