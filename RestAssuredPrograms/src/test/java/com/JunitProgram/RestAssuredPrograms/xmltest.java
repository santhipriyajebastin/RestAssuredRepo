package com.JunitProgram.RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;

@Test
public class xmltest {
	public void testXmlResponse() {
	RestAssured
		.given()
			.baseUri("https://www.w3schools.com/xml/note.xml")
		.when()
			.get()
		.then()
			.statusCode(200)
			.body("note.to", equalTo("Tove"));
	}

}
