package com.example.github;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class githubAuthTest {
	private static final String BASE_URL = "https://api.github.com";
	private static final String TOKEN = "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";
	private static final String Username = "santhipriyajebastin";
	private static final String repname = "learning";
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI=BASE_URL;
	}
	
	//to fetch user details
	//header("Authorization","Bearer " + TOKEN)
	@Test
	public void testgetAuthenticatedUser() {
		Response response = RestAssured.given()
								.auth().oauth2(TOKEN)
							.when()
								.get("/user")
							.then()
								.statusCode(200)
							.extract()
								.response();
		
		System.out.println("Response Body " + response.asPrettyString());
		
		Assert.assertEquals(response.statusCode(),200,"expected status code is 200, but recieved the status code as : " + response.statusCode());
		Assert.assertEquals(response.jsonPath().getString("login"),"santhipriyajebastin","recieved login is invalid. which is : " + response.jsonPath().getString("login"));
	}
	
	@Test
	public void invalidauthentication() {
		Response response = RestAssured.given()
								.header("Authorization","Bearer " + "invalid")
							.when()
								.get("/user")
							.then()
								.statusCode(401)
							.extract()
								.response();
		String expectedmessage = "Bad credentials";
		String actualmessage = response.jsonPath().getString("message");
		
		System.out.println("Response Body " + response.asPrettyString());
		Assert.assertTrue(actualmessage.equals(expectedmessage),"invalid response");
	}
	
	@Test
	public void repositoryTest() {
		Response response = RestAssured.given()
											.header("Authorization", "Bearer " + TOKEN)
										.when()
                							.get("/repos/" + Username + "/" + repname)
										.then()
											.statusCode(200)
										.extract()
											.response();
		
		System.out.println("response is " + response.asPrettyString());
											
				
	}

}
