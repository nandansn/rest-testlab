package com.nanda.rest.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;



import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ProductServices {

	@BeforeTest
	public void initConfig() {

		RestAssured.baseURI = "http://localhost:8891/product-service/v1/products";

	}

	

	@Test
	public void testGetProducts() {

		given().contentType(ContentType.JSON).get().then().assertThat().statusCode(200);

	}
	
	@Test(description="to read the response from get request")
	public void testGetProductsRes() {
		
		List<String> products =given().contentType(ContentType.JSON).get().getBody().jsonPath().getList("products"); // returns list of  hashmap of hashmap
		
		
		
		for (Iterator iterator = products.iterator(); iterator.hasNext();) {
			HashMap<String,String> string = (HashMap<String,String>) iterator.next();
			
			
			
			assertThat(string.size(), is(9));
		}
	}
	
	@Test
	public void testHeaders() {
		
	List<Header> headers = head().headers().asList();
	
	for (Iterator iterator = headers.iterator(); iterator.hasNext();) {
		Header header = (Header) iterator.next();
		
		System.out.println(header.getName()+":"+header.getValue());
		
	}
	}
	
	@Test
	public void testOptions() {
		for(Header header: options().headers().asList())
			System.out.println(header.getName()+":"+header.getValue());
	}

}


/*@Test(enabled=false)
public void createData() {

	String myJson = "{" + "\"productName\":\"Hummer" + new Random().nextInt() + "\"," + "\"price\":\"1000\","
			+ "\"category\":\"Mobile\"," + "\"description\":\"Sports Car - Toys\"" + "}";

	given().contentType("application/json").body(myJson).when().post("").then().statusCode(200);

}*/