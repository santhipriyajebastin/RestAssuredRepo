package com.JunitProgram.RestAssuredPrograms;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class WeathweAPItest {
	@Test
	public void testGetWeather() {
	// Sending a GET request to fetch weather data for "London"
	RestAssured.given()
				.param("q", "London") // Query parameter for city
				.param("appid", "bd07e0b914a4be2bcec7ebfa7901cb9e") // Your OpenWeatherMap API key - directly getting through the application(n need to login).
				.when()
				.get("http://api.openweathermap.org/data/2.5/weather")
				.then()
				.statusCode(200) // Validate the HTTP Status code is 200
				.log().body() // Log the response body
				.body("name", org.hamcrest.Matchers.equalTo("London")); // Validate city name in response
	}
	}


