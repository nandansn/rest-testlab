package com.nanda.rest.test;

import static org.testng.Assert.*;

import org.apache.log4j.Logger;

import static org.apache.log4j.Logger.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ServiceHealthCheckTest {

	static String configServiceURL = "http://localhost:8888/health";

	static String discoveryServiceURL = "http://localhost:8761/health";
	
	static String apiGatewayURL ="http://localhost:8891/health";

	final static Logger logger = Logger.getLogger(ServiceHealthCheckTest.class);

	@Test
	public void testConfigServiceIsUp() {

		Response response = get(configServiceURL).then().statusCode(200).contentType(ContentType.JSON).extract()
				.response();

		logger.info(String.format("%s:%s", "JSON Response", response.asString()));

		assertEquals(response.jsonPath().get("status"), "UP");

	}

	@Test
	public void testDiscoveryServiceIsUp() {

		Response response = get(discoveryServiceURL).then().statusCode(200).contentType(ContentType.JSON).extract()
				.response();

		System.out.println(response.asString());

		logger.info(String.format("%s:%s", "JSON Response", response.asString()));

		assertEquals(response.jsonPath().get("status"), "UP");

	}
	
	@Test
	public void testAPIGatewayIsUp() {

		Response response = get(apiGatewayURL).then().statusCode(200).contentType(ContentType.JSON).extract()
				.response();
		
		

		System.out.println(response.asString());

		logger.info(String.format("%s:%s", "JSON Response", response.asString()));

		assertEquals(response.jsonPath().get("status"), "UP");

	}

}
