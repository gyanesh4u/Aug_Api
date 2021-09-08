package api_august_tutorial;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PrintResponse {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		res.prettyPrint();
	//	res.peek();//It will print all the thing like body,header,status line
		res.prettyPeek();//It print everything in preety format
	}
}
