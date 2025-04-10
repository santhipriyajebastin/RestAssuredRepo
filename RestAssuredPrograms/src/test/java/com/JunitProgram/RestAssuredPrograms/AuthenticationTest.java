package com.JunitProgram.RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AuthenticationTest {
	@Test
    public void testBasicAuth() {
        RestAssured
            .given()
            .auth()
            .basic("username", "password")  // Provide username and password
            .when()
            .get("https://api.example.com/secure-endpoint")  // Example API endpoint
            .then()
            .statusCode(200);  // Assert status code is 200 OK
    }
}


