package stepDefination;

import Utilities.Payloads;
import Utilities.common_base_methods;
import Utilities.pathUrls;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
public class addToCart {
	RequestSpecification req;
	Response response;
	static Payloads data = new Payloads();
	
	AALogin login = new AALogin();
	String token = login.token;
	
	@Given("The user provides the payload")
	public void the_user_provides_the_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		req = given().spec(common_base_methods.RequestSpecification()).header("Authorization", token).body(Payloads.addToCartPayload());
		
	}
	
	@When("The user sends a {string} HTTP request method to the  {string}")
	public void the_user_sends_a_http_request_method_to_the(String method, String url) {
	    // Write code here that turns the phrase above into concrete actions
		pathUrls urls = pathUrls.valueOf(url);
		System.out.println(url);
		if (method.equalsIgnoreCase("POST"))
			response = req.when().post(urls.getUrls());
		else if(method.equalsIgnoreCase("GET"))
			response = req.when().get(urls.getUrls());
	}

	@Then("The system should return a {int} status code")
	public void the_system_should_return_a_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.statusCode(), 200);
	}

}
