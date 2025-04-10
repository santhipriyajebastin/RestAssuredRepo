package com.JunitProgram.RestAssuredPrograms;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import org.testng.annotations.Test;

@Test
public class advtestGithub {
	// Set up the base URI for GitHub API
	private static final String GITHUB_BASE_URI = "https://api.github.com";
	private static final String GITHUB_TOKEN = "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"; // Replace with your token
	// RequestSpecification for reusable request config
//	@Test
//	public void testRequestSpecification() {
//		RestAssured.baseURI = GITHUB_BASE_URI;//base url for api req
//			// Define a request specification
//		RequestSpecification requestSpec = given()
//												.header("Authorization", "Bearer " + GITHUB_TOKEN)
//												.header("Content-Type", "application/json")
//												.log().all(); // Log request for debugging
//	// Define a response specification to check the response status code and content type
//		ResponseSpecification responseSpec = expect()
//												.statusCode(200)
//												.contentType("application/json");
//	// Use the request specification and response specification in the API call
//		Response response = requestSpec
//							.when()
//								.get("/user") // Get authenticated user's details from GitHub API
//							.then()
//								.spec(responseSpec) // Apply response validation
//							.extract().response();
//	// Print the response body
//		System.out.println("Response Body: " + response.getBody().asString());
//		}
//	
//	
	// Dynamic Parameters: Using path params and query params
//	public void testWithDynamicParameters() {
//		// Set the base URI for GitHub API
//		RestAssured.baseURI = GITHUB_BASE_URI;
//		String username = "santhipriyajebastin"; // Example GitHub username
//		String repository = "learning"; // Example repository
//		// Send GET request with dynamic parameters
//		Response response = given()
//								.pathParam("username", username) // Path parameter for the username
//								.pathParam("repo", repository) // Path parameter for the repository name
//								.header("Authorization", "Bearer " + GITHUB_TOKEN) // Authorization header
//							.when()
//								.get("/repos/{username}/{repo}") // Send the GET request to GitHub API
//							.then()
//								.statusCode(200) // Assert status code is 200 (OK)
//								.body("name", equalTo(repository)) // Assert the repository name matches
//								.body("owner.login", equalTo(username)) // Assert the owner's username matches
//								.extract().response(); // Extract the response
//							// Print the response body
//		System.out.println("Response Body: " + response.getBody().asString());
//		System.out.println(" statuscode: " + response.getStatusCode());
//		System.out.println(" header : " + response.getHeaders());
//		System.out.println(" coockies and time : " + response.getCookies() + " " + response.getTime());
//		}
//
	
	
//	// Handling File Upload and Form Data
	@Test
	public void testFileUpload() {
		RestAssured.baseURI = "https://httpbin.org"; // Example file upload endpoint
	// Uploading a file along with form data
			File file = new File("C:/Users/jebas/eclipse-workspace/Practice/file.txt"); // Replace with an actual file path
						given()
							.multiPart("file", file)
							.formParam("description", "Test file upload")
						.when()
							.post("/post") // HTTP POST to the /post endpoint
						.then()
							.statusCode(200)
							.body("files.file", containsString("AAI am Santhi"))
							.body("form.description", equalTo("Test file upload"));
	}
//	// Logging request and response details
//	@Test
//	public void testLogging() {
//	RestAssured.baseURI = GITHUB_BASE_URI;
//	// Log request and response details
//	given()
//	.header("Authorization", "Bearer " + GITHUB_TOKEN)
//	.header("Content-Type", "application/json")
//	.log().all() // Log all request details
//	.when()
//	.get("/user")
//	.then()
//	.log().body() // Log the response body
//	.statusCode(200);
//	}
	
}





