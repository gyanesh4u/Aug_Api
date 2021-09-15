package pojo;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class CreateGitHubRepo {

	public static void main(String[] args) {
		String url="https://api.github.com/orgs/gyanesh4uorg/repos";
		
		String authToken="Bearer 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";
		CreateRepoPOJO obj=new CreateRepoPOJO();
		obj.setName("Repo-from-serialization_1");
		obj.setDescription("This repository is created from code");
		obj.setPrivateVal(true);
		RestAssured
		.given()
			.header("Authorization",authToken)
			.body(obj)
		.when()
		.log().all()
			.post(url)
		.then()
		.log().all()
			.assertThat()
			.statusCode(201)
			.assertThat()
			.body("name",Matchers.equalTo("srishti"))
			.body("full_name",Matchers.equalTo("gyanesh4uorg/srishti"));
	}
}
