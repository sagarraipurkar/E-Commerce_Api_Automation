package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefination.AALogin;

public class common_base_methods {
	
	public static RequestSpecification request;
    @Before
	public static RequestSpecification RequestSpecification() throws IOException {
		if(request== null) {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		request = new RequestSpecBuilder().setBaseUri(common_base_methods.GetEnvUrls("baseurl"))
				.addHeader("Content-Type", "application/json")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return request;
	}
	 return request;
	}	
	public static String GetEnvUrls(String url) throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Eclipse New\\NewWorkSpace\\BookingAPIAutomation_Cucumber\\src\\test\\java\\Utilities\\global.properties");
		prop.load(fs);
		return prop.getProperty(url).toString();
	}
	
	public String getJsonpath(Response response,  String key) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.get(key).toString();
	}
	
	public static String get_token() {
		AALogin token1 = new AALogin();
		String token = token1.token;
		return token;
		
	}

}
