package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class LogRequestResponseToFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintStream printOut=new PrintStream(new FileOutputStream("logfile.txt"));
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="api/users";
		String url="{userId}";
		RequestSpecBuilder reqSpec=new RequestSpecBuilder();
		reqSpec.addFilter(RequestLoggingFilter.logRequestTo(printOut));
		reqSpec.addFilter(ResponseLoggingFilter.logResponseTo(printOut));
		RestAssured.requestSpecification=reqSpec.build();
		RestAssured
		.given()
		.pathParam("userId",1)
		.when()
		
		.get(url)
		.then()
		.assertThat().statusCode(200);
		
	}
}
