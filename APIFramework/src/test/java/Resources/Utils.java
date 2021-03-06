package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification request;
	
	public RequestSpecification RequestMethod() throws IOException
	{
		if(request==null)
		{
		PrintStream logs = new PrintStream(new FileOutputStream("logs.txt"));
		 request =new RequestSpecBuilder().setBaseUri(getValueFromPropertiesFile("baseUrl"))
				 .addFilter(RequestLoggingFilter.logRequestTo(logs))
				 .addFilter(ResponseLoggingFilter.logResponseTo(logs))
				.addQueryParam("key", "qaclick123").addHeader("Content-Type", "application/json").build();
		 return request;
		}
		return request;
	}

	public static String getValueFromPropertiesFile(String keyvalue) throws IOException
	{
		Properties prop=new Properties();   //Properties class will read all the files with Extention.properties
		FileInputStream fis= new FileInputStream("C:\\Users\\kbsne\\demoAPIProject\\APIFramework\\src\\test\\java\\Resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(keyvalue);
		
	}
	
	public String getJsonPath(Response responce, String keyvalue)
	{
		String resp=responce.asString();  //converting the jsonResponse to string 
		JsonPath js= new JsonPath(resp);
		return js.get(keyvalue).toString();
	}
}
