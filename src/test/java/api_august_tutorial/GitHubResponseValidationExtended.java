package api_august_tutorial;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class GitHubResponseValidationExtended {

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
		.body("name",Matchers.contains("New-Repo","repo_123"))
		.rootPath("owner[0]")
		.body("url",Matchers.equalTo("https://api.github.com/users/gyanesh4uorg"))
		.body("id",Matchers.equalTo(89117060))
		.body("login",Matchers.equalTo("gyanesh4uorg"))
		.body("",Matchers.hasKey("organizations_url"));
	}
}
