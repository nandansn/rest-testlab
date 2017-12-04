package com.nanda.rest.test;

import org.testng.annotations.Test;

import com.google.common.collect.Multiset.Entry;
import com.sun.javafx.collections.MappingChange.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import static io.restassured.path.xml.XmlPath.*;

public class FirstTest {

	@Test
	private void testOne() {

		Response response = get(" http://localhost:8082/pgs/api/auth/v1/products").then().statusCode(200).contentType(ContentType.JSON).extract()
				.response();
		
		System.out.println(response.asString());

		ArrayList<HashMap<String, ?>> jsonAsArrayList = from(response.asString()).get("");
		
		for (HashMap<String, ?> map : jsonAsArrayList) {
			
			Set<?> entrySet =map.entrySet();
				Iterator<String> itr =(Iterator<String>)entrySet.iterator();
				
				while(itr.hasNext()) {
					System.out.println(itr.next());
				}
			
			}
			
		}
	}


