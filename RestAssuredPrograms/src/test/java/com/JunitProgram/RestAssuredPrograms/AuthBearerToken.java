package com.JunitProgram.RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

//githubtoken - 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

public class AuthBearerToken {
	@Test
    public void testBearerToken() {
        RestAssured
            .given()
            	.auth()
            	.oauth2("your_bearer_token_here")
            .when()
            	.get("https://api.example.com/secure-endpoint")
            .then()
            	.statusCode(200);
    }

}
