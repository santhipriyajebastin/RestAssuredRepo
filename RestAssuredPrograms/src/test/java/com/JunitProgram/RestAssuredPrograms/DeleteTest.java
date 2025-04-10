package com.JunitProgram.RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTest {
	@Test
	public void testCreateUser() {
	// Base URL of the API
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		// Request Body for creating a new user
		// Sending a POST request to create the user
		String requestBody = "{ \"name\": \"John\", \"age\": 35 }";//json fromat
		Response response = RestAssured.given()
							.header("Content-Type", "application/json")
							.body(requestBody)
							.when()
							.delete("/users/1")
							.then()
							.statusCode(200)
							.extract().response();
		// Print the response
		System.out.println("Response: " + response.asString());
		
		
}
}
