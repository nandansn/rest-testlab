package com.nanda.rest.qube;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import static io.restassured.RestAssured.*;
import java.util.List;

@Test
public class QubeTest {

	public static final String userToken = "1900672b-cf29-4b34-97e1-f363c71ac450";
	public static final String apiURL = "https://ec2-52-66-89-105.ap-south-1.compute.amazonaws.com/sharebox/api/";

	@BeforeClass
	public void ignoreCertificateValidation() {
		RestAssured.authentication = basic("foo", "bar");
		RestAssured.baseURI = apiURL;
		RestAssured.useRelaxedHTTPSValidation();
	}

	@Test
	public void testGetListOFiles() throws Exception {
		String listOfFilesResource = "files";

		XmlPath htmlPath = given().param("token", userToken).param("Accept", "application/json").when()
				.get(apiURL + listOfFilesResource).then().statusCode(200).extract().body().htmlPath();

		List<SharedFile> sharedFiles = SharedFileUtil.extractSharedFiles(htmlPath);
		
		sharedFiles.forEach(System.out::println);

	}
	
	

}
