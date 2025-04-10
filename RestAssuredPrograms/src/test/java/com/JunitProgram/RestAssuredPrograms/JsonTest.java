package com.JunitProgram.RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.greaterThan;

public class JsonTest {
	@Test
	public void testValidateJsonResponse() {
	RestAssured
	.given()
		.param("q", "London")
		.param("appid", "bd07e0b914a4be2bcec7ebfa7901cb9e")//without login we can go through the application.
	.when()
		.get("http://api.openweathermap.org/data/2.5/weather")
	.then()
		.statusCode(200)
		.body("main.temp", greaterThan(270.0f));//only rest assured can do
}
}