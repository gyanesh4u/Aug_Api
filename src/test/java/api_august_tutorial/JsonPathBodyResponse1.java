package api_august_tutorial;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathBodyResponse1 {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users?page=1");
		String body = res.getBody().asString();
		System.out.println(body);
		JsonPath jPath = new JsonPath(body);
		int perPage = jPath.getInt("per_page");
		System.out.println(perPage);
		JsonPath jsonPath = res.getBody().jsonPath();
		// get the response body by using getBody() and call method jsonPath()
		String text = jsonPath.getString("support.text");
		System.out.println(text);
	}
}
