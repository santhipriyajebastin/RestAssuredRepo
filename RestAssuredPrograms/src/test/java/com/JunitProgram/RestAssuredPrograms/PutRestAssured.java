package com.JunitProgram.RestAssuredPrograms;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutRestAssured {
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
		.put("/users/1")
		.then()
		.statusCode(200)
		.extract().response();
		// Print the response
		System.out.println("Response: " + response.asString());
		// Extract the user ID from the response and assert it's not null
		int userId = response.jsonPath().getInt("id");
		Assert.assertNotNull(userId, "User ID should not be null.");
		}

}
