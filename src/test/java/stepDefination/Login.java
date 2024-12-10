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
import java.net.URI;

import io.restassured.specification.RequestSpecification;
import pojo.credentails;

public class Login extends common_base_methods {

	RequestSpecification req;
	Response response;

	@Given("The user provides the login payload")
	public void the_user_provides_the_login_payload() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Payloads data = new Payloads();
		req = given().spec(common_base_methods.RequestSpecification()).body(data.LoginPayload("John@mailinator.com", "Sagar@91"));
	}

	@When("The user sends a POST HTTP request to the Login URL")
	public void the_user_sends_a_post_http_request_to_the_login_url() {
		// Write code here that turns the phrase above into concrete actions
//		pathUrls url = pathUrls.valueOf("pathUrls");
//		System.out.println(url);
		response = req.when().post(pathUrls.LoginpathApi.getUrls());
	}

	@Then("The system should return a valid status code")
	public void the_system_should_return_a_valid_status_code() {
		// Write code here that turns the phrase above into concrete actions
		String res = response.asString();
		JsonPath js1 = new JsonPath(res);
		assertEquals(response.statusCode(), 200);

	}
}
