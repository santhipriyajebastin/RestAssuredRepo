package com.JunitProgram.RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AuthAPITest {
	@Test
	public void testWithBasicAuth() {
		RestAssured.given()
			.auth().basic("username", "password") // Basic Authentication
		.when()
			.get("https://api.example.com/protected")
		.then()
			.statusCode(200); // Validate that the request was successful
	}
}	
