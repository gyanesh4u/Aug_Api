package api_august_tutorial;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetStatusCode {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		int statusCode = res.getStatusCode();
		System.out.println(statusCode);
		String line = res.getStatusLine();
		System.out.println(line);
	}
}
