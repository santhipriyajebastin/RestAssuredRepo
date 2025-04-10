package com.JunitProgram.RestAssuredPrograms;
import static io.restassured.RestAssured.*;//methods given(),when(),then()

import com.github.tomakehurst.wiremock.client.WireMock;//methods to interact with wiremock server(stubbing req)
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;//configuring and customising the server which port
import com.github.tomakehurst.wiremock.WireMockServer;//to create, start and stop my stub server
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class WiremockTest {

    private WireMockServer wireMockServer;  // Declare a WireMockServer instance(object) to configuare and run my mock server.

    @BeforeClass  // This will run before any tests in the class
    public void setUp() {
        try {
            // Initialize the WireMockServer on port 8089
            wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8089));  // Initialize WireMock server
            wireMockServer.start();  // Start the WireMock server
            System.out.println("WireMock server started on port 8089");

            // Configure WireMock for localhost
            WireMock.configureFor("localhost", 8089);  // Setup WireMock client for interaction, dummy one
        } catch (Exception e) {
            System.err.println("Error occurred while starting the WireMock server: " + e.getMessage());
            e.printStackTrace();
            throw e;  // Re-throw the exception to fail the test if setup fails
        }
    }

    @AfterClass  // This will run after all tests are executed
    public void tearDown() {
        try {
            // Stop the WireMock server after the tests
            if (wireMockServer != null) {
                wireMockServer.stop();
                System.out.println("WireMock server stopped");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while stopping the WireMock server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testMockingWithWireMock() {
        try {
            // Stubbing a GET request for a user endpoint
            stubFor(get(urlEqualTo("/users/123"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody("{\"id\": \"123\", \"name\": \"John Doe\"}")));

            // Use RestAssured to make the request to the mocked server
            String response = given()
                    .baseUri("http://localhost:8089")  // Ensure the port matches the WireMock server
                    .when()
                    .get("/users/123")
                    .then()
                    .statusCode(200)
                    .extract().body().asString();

            // Print the response to the console
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Error during test execution: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

