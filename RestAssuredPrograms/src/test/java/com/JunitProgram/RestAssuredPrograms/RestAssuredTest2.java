package com.JunitProgram.RestAssuredPrograms;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredTest2 {
	@Test
	public void testCreateUser() {
	// Base URL of the API
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	// Request Body for creating a new user
	String requestBody = "{ \"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"password\": \"password123\" }";
	// Sending a POST request to create the user
	Response response = RestAssured.given()
						.header("Content-Type", "application/json")
						.body(requestBody)
						.when()
						.post("/users")
						.then()
						.statusCode(201) // Assert that the user was created successfully
						.extract()
						.response();
	// Print the response
	System.out.println("Response: " + response.asString());
	// Extract the user ID from the response and assert it's not null
	int userId = response.jsonPath().getInt("id");
	System.out.println(userId);
	Assert.assertNotNull(userId, "User ID should not be null.");
	}
	
}
