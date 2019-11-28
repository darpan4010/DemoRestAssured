package basics;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import files.Payload;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StaticJson {

	
public void FirstTest(String isbnNumber, String aisleNumber) throws IOException {
		
		RestAssured.baseURI = "http://216.10.245.166";
		Response res = given().
				header("Content-Type","application/json").
				body(GenerateStringfromResource(System.getProperty("user.dir")+"\\src\\files\\AddBookDetails.json")).
				//body(Payload.addBook(isbnNumber,aisleNumber)).
				log().all().when().
				post("/Library/Addbook.php").
				then().log().all().assertThat().statusCode(200).and().contentType(ContentType.JSON).
				/*body("status",equalTo("OK")).*/extract().response();
		
		JsonPath js = ReusableMethods.rawtoJSONfile(res);
		String statusCOde = js.get("ID");
		System.out.println("Status Code is :-"+statusCOde);
		
		System.out.println(res.asString());
				
		
	}

public static String GenerateStringfromResource(String path) throws IOException
{
	return new String(Files.readAllBytes(Paths.get(path)));
}
}
