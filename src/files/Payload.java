package files;

public class Payload {

	
	
	public static String getaddString()
	{
		String addString = "{\r\n" + 
				"\r\n" + 
				"    \"location\":{\r\n" + 
				"\r\n" + 
				"        \"lat\" : -38.383494,\r\n" + 
				"\r\n" + 
				"        \"lng\" : 33.427362\r\n" + 
				"\r\n" + 
				"    },\r\n" + 
				"\r\n" + 
				"    \"accuracy\":50,\r\n" + 
				"\r\n" + 
				"    \"name\":\"Frontline house\",\r\n" + 
				"\r\n" + 
				"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
				"\r\n" + 
				"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
				"\r\n" + 
				"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
				"\r\n" + 
				"    \"website\" : \"http://google.com\",\r\n" + 
				"\r\n" + 
				"    \"language\" : \"French-IN\"\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"";
				
				return addString;		
	}
	
	public static String getdeleteString(String placeID)
	{
		
		String deleteString = "\r\n" + 
				"{\r\n" + 
				"    \"place_id\":\""+placeID+"\"           \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"";
				
				return deleteString;
	}
	
	public static String addBook(String isbnNumber, String aisleNumber)
	{
		String bookAPI = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbnNumber+"\",\r\n" + 
				"\"aisle\":\""+aisleNumber+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"";
		return bookAPI;
	}
}
