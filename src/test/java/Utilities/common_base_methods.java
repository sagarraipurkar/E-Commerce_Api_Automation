package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class common_base_methods {
	
	public static RequestSpecification RequestSpecification() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		RequestSpecification request = new RequestSpecBuilder().setBaseUri(common_base_methods.GetEnvUrls("baseurl")).addHeader("Content-Type", "application/json")
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return request;
	}
	
	public static String GetEnvUrls(String url) throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Eclipse New\\NewWorkSpace\\BookingAPIAutomation_Cucumber\\src\\test\\java\\Utilities\\global.properties");
		prop.load(fs);
		return prop.getProperty(url).toString();
	}

}
