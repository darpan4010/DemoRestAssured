package basics;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import com.sun.xml.fastinfoset.sax.Properties;

import files.Payload;
import files.Resources;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class BasicRestAssured3 {

	java.util.Properties props;
	@BeforeTest
	public void getData() throws IOException
	{
	props = new java.util.Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\files\\env.properties");
	props.load(fis);
	props.get("HOST");
		
	}
	@Test
	public void FirstTest() {
		
		RestAssured.baseURI = props.getProperty("HOST");;
		Response res = given().
				queryParam("key",props.getProperty("KEY")).
				body(Payload.getaddString()).when().
			
				//Grab the response.
				
				post(Resources.addplacePostData()).
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
				body("status",equalTo("OK")).extract().response();
				
				String responseString = res.asString();
				System.out.println(responseString);
				
				//Grab the placeID from response.
				JsonPath jsPath = new JsonPath(responseString);
				String placeID = jsPath.get("place_id");
				System.out.println(placeID);
				
				
				//Task to process delete rewuest.
				
				given().
					queryParam("key","qaclick123").
				body(Payload.getdeleteString(placeID)).
				when().
					post(Resources.deleteplacePostData()).
				then()
					.assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("status", equalTo("OK"));
				
				
	}

}
