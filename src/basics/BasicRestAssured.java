package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
public class BasicRestAssured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://216.10.245.166";
		given().
				param("location","-38.383494,33.427362").
				param("key","qaclick123").
		when().
				get("/maps/api/place/delete/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON);    //by this point we will get response and it is stored in some virtual storage.
	}
}
