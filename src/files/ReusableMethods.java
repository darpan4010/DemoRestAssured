package files;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {

	
	public static XmlPath rawtoXMLfile(Response res)
	{
		XmlPath xml = new XmlPath(res.asString());
		return xml;
		
		
	}
	
	public static JsonPath rawtoJSONfile(Response res)
	{
		JsonPath json = new JsonPath(res.asString());
		return json;
		
		
	}
}
