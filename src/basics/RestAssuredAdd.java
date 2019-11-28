package basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RestAssuredAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI = "http://216.10.245.166";
		given().
				param("location","-38.383494,33.427362").
				param("key","qaclick123").
		when().
				get("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	}

}
