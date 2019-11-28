package basics;

import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;
import groovy.util.logging.Log;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.text.IsBlankString;
public class DynamicJson {

	@Test(dataProvider = "BooksData")
	public void FirstTest(String isbnNumber, String aisleNumber) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		Response res = given().
				header("Content-Type","application/json").
				body(Payload.addBook(isbnNumber,aisleNumber)).log().all().when().
				post("/Library/Addbook.php").
				then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON).
				/*body("status",equalTo("OK")).*/extract().response();
		
		JsonPath js = ReusableMethods.rawtoJSONfile(res);
		String statusCOde = js.get("ID");
		System.out.println("Status Code is :-"+statusCOde);
		
		System.out.println(res.asString());
				
				
	}
	@DataProvider(name="BooksData")
	public Object[][] getbookData()
	{
		
		return new Object[][] {{"darpan","123"},{"sathe","5667"},{"dar","876"}};
		
	}

}
