package basics;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import files.ReusableMethods;
import groovy.util.logging.Log;

import static org.hamcrest.Matchers.equalTo;
public class BasicRestAssured4_XML {

	@Test
	public void FirstTest() {
		
		RestAssured.baseURI = "http://216.10.245.166";
		Response res = given().
				queryParam("key","qaclick123").
				body("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n" + 
						"<root>\r\n" + 
						"    <location>\r\n" + 
						"        <lat>-38.383494</lat>\r\n" + 
						"        <lng>33.427362</lng>\r\n" + 
						"    </location>\r\n" + 
						"    <accuracy>50</accuracy>\r\n" + 
						"    <name>The Mens store</name>\r\n" + 
						"    <phone_number>(+91) 983 893 3937</phone_number>\r\n" + 
						"    <address>Anna Salai, Chennai</address>\r\n" + 
						"    <types>shoe park</types>\r\n" + 
						"    <types>kadai</types>\r\n" + 
						"    <website>http://google.com</website>\r\n" + 
						"    <language>tamil-IN</language>\r\n" + 
						"</root>\r\n" + 
						"\r\n" + 
						"").log().all().when().
				post("/maps/api/place/add/xml").
				then().log().all().assertThat().statusCode(200).and().contentType(ContentType.XML).
				/*body("status",equalTo("OK")).*/extract().response();
		
		XmlPath xml = ReusableMethods.rawtoXMLfile(res);
		String statusCOde = xml.get("response.status");
		System.out.println("Status Code is :-"+statusCOde);
		
		System.out.println(res.asString());
				
				
	}

}
