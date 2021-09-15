package pojo;

import io.restassured.RestAssured;

public class ReqResGetUser {

	public static void main(String[] args) {
		String url="https://reqres.in/api/users/2";
		ReqresRootPOJO obj=RestAssured
				.given()
				.when()
					.get(url)
				.then()
					.extract().response().body().as(ReqresRootPOJO.class);
		String email = obj.getData().getEmail();
		System.out.println(email);
		String text=obj.getSupport().getText();
		System.out.println(text);
	}
}
