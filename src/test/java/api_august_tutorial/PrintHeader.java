package api_august_tutorial;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PrintHeader {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.getHeaders());
		String header = res.getHeader("Content-Type");
		System.out.println(header);
		String server = res.getHeader("server");
		System.out.println(server);
	}
}
