package seranddes;

import io.restassured.RestAssured;
import pojo.CreateRepoPOJO;

public class CreateGithubRepoTest {

	public static void main(String[] args) {
		String url = "https://api.github.com/orgs/gyanesh4uorg/repos";				

		String authToken = "Bearer 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";
		
		CreateRepoPOJO obj = new CreateRepoPOJO();
		obj.setName("Repo-from-serialization_7");
		obj.setDescription("This repository is created from code");
		obj.setPrivateVal(true);			
		
		CreateGithubRepoResponsePOJO resObj = RestAssured
		.given()
			.header("Authorization", authToken)
			.body(obj)
		.when()
			.log().all()
			.post(url)
		.then()
			.log().all()
			.assertThat()
				.statusCode(201)
			.extract().response().body().as(CreateGithubRepoResponsePOJO.class);	
		
		
		String fullName = resObj.getFull_name();
		String desc = resObj.getDescription();
		
		System.out.println(fullName);
		System.out.println(desc);
		
	}

}

