package api_august_tutorial;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstRequest {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		//res.prettyPrint();
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		
	}
}
