package com.JunitProgram.RestAssuredPrograms;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredTest {
	@Test
    public void testGetRequest() {
        // Base URL of the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
 
        // Sending a GET request to the API
        Response res = RestAssured.given()
                .when()
                .get("/posts/1") // endpoint for posts
                .then()
                .extract()
                .response();
 
        // Print the response
        System.out.println("Response: " + res.asString());
        System.out.println("Status code: " + res.statusCode());
        System.out.println("Status code: " + res.asPrettyString());
        System.out.println("Status code: " + res.contentType());
        System.out.println("Status code: " + res.getSessionId());
 
        // Assert the response status code
        Assert.assertEquals(res.getStatusCode(), 200);
    }
}

