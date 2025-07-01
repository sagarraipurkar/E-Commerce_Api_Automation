package stepDefination;

import Utilities.Payloads;
import Utilities.common_base_methods;
import Utilities.pathUrls;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

import org.junit.BeforeClass;


import io.restassured.specification.RequestSpecification;
import pojo.credentails;



public class AALogin extends common_base_methods {

	RequestSpecification req;
	Response response;
	static Payloads data = new Payloads();
	public static String token;

//Verify User is able to log in with valid credentials
	@Given("The user provides the login payload with {string} {string}")
	public void the_user_provides_the_login_payload_with(String userEmail, String userPassword) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		req = given().spec(common_base_methods.RequestSpecification()).body(data.LoginPayload(userEmail, userPassword));
	}
	
	@When("The user sends a {string} HTTP request to the {string}")
	public void the_user_sends_a_http_request_t(String method, String url) {
		// Write code here that turns the phrase above into concrete actions
		pathUrls urls = pathUrls.valueOf(url);
		System.out.println(url);
		if (method.equalsIgnoreCase("POST"))
			response = req.when().post(urls.getUrls());
		else if(method.equalsIgnoreCase("GET"))
			response = req.when().get(urls.getUrls());
	}

	@Then("The system should return a valid status code")
	public void the_system_should_return_a_valid_status_code() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.statusCode(), 200);
		token = getJsonpath(response, "token");

	}

//	Verify user not able to login with invalid UserEmail id
	@Given("The user provides the login payload with an invalid {string} but with an correct {string}")
	public void the_user_provides_the_login_payload_with_an_invalid_but_with_an_correct(String userEmail,
			String userPassword) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		req = given().log().all().spec(common_base_methods.RequestSpecification())
				.body(data.LoginPayload(userEmail, userPassword));
	}

	@Then("The system should return a {int} Unauthorized status code")
	public void the_system_should_return_a_unauthorized_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.statusCode(), 400);
	}

	@Then("The system should return an appropriate error message such as {string}")
	public void the_system_should_return_an_appropriate_error_message_such_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		String message = getJsonpath(response, "message");
		assertEquals(message, "Incorrect email or password.");
	}

//Verify User is not able to log in with an incorrect password
	@Given("The user provides the login payload with a valid {string} but an incorrect {string}")
	public void the_user_provides_the_login_payload_with_a_valid_but_an_incorrect(String userEmail, String userPassword)
			throws IOException {
		// Write code here that turns the phrase above into concrete actions
		req = given().spec(common_base_methods.RequestSpecification()).body(data.LoginPayload(userEmail, userPassword));
	}
	
//	@Given("The user provides the payload")
//	public void the_user_provides_the_payload() throws IOException {
//	    // Write code here that turns the phrase above into concrete actions
//		req = given().spec(common_base_methods.RequestSpecification()).header("Authorization", token).body("{\r\n"
//				+ "    \"_id\": \"66ffc3ccae2afd4c0b8ee658\",\r\n"
//				+ "    \"product\": {\r\n"
//				+ "        \"_id\": \"6749631dae2afd4c0bd1f7f8\",\r\n"
//				+ "        \"productName\": \"ADIDAS ORIGINAL\",\r\n"
//				+ "        \"productCategory\": \"household\",\r\n"
//				+ "        \"productSubCategory\": \"shoes\",\r\n"
//				+ "        \"productPrice\": 31500,\r\n"
//				+ "        \"productDescription\": \"Adidas shoes for Men\",\r\n"
//				+ "        \"productImage\": \"https://rahulshettyacademy.com/api/ecom/uploads/productImage_1650649488046.jpg\",\r\n"
//				+ "        \"productRating\": \"0\",\r\n"
//				+ "        \"productTotalOrders\": \"0\",\r\n"
//				+ "        \"productStatus\": true,\r\n"
//				+ "        \"productFor\": \"men\",\r\n"
//				+ "        \"productAddedBy\": \"admin@gmail.com\",\r\n"
//				+ "        \"__v\": 0\r\n"
//				+ "    }\r\n"
//				+ "}");
//	}
//	@Then("The system should return a {int} status code")
//	public void the_system_should_return_a_status_code(Integer int1) {
//	 assertEquals(response.statusCode(), 200);
//		
//	}

}
