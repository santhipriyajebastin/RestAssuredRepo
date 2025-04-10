package com.JunitProgram.RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostRestAssured {
	@Test
	public void testCreateUser() {
	// Sample data to create a new user
	String jsonBody = "{\"name\":\"John\", \"job\":\"Engineer\"}";
		RestAssured.given()
		.header("Content-Type", "application/json")
		.body(jsonBody) // Set the request body
		.when()
		.post("https://reqres.in/api/users") // POST request to create a new user
		.then()
		.statusCode(201) // Status code should be 201 for successful creation
		.body("name", org.hamcrest.Matchers.equalTo("John")) // Validate name in response
		.body("job", org.hamcrest.Matchers.equalTo("Engineer")); // Validate job in response
	}
}
