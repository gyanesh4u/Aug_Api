package api_august_tutorial;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PrintResponseBody {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		//System.out.println(res.body());
		//ResponseBody resBody = res.getBody();
		//resBody.print();
		//resBody.prettyPeek();
		String resBody="{\r\n"
				+ "    \"data\": {\r\n"
				+ "        \"id\": 2,\r\n"
				+ "        \"email\": \"janet.weaver@reqres.in\",\r\n"
				+ "        \"first_name\": \"Janet\",\r\n"
				+ "        \"last_name\": \"Weaver\",\r\n"
				+ "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\r\n"
				+ "    },\r\n"
				+ "    \"support\": {\r\n"
				+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
				+ "    }\r\n"
				+ "}";
		JsonPath jPath=new JsonPath(resBody);
		String emailVal = jPath.get("data.email");
		System.out.println(emailVal);
		String fName = jPath.get("data.first_name");
		System.out.println(fName);
		String lName = jPath.get("data.last_name");
		System.out.println(lName);
		String url = jPath.get("support.url");
		System.out.println(url);
		String text = jPath.get("support.text");
		System.out.println(text);
	}
}
