package StepDefinition;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import Resources.APIResources;
import Resources.TestBuildData;
import Resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MapsStepDefinition extends Utils
{
	 RequestSpecification	requ;
	 
	 ResponseSpecification response;
	 Response resp;
	 TestBuildData data= new TestBuildData();
	static String place_id;
	 
	 @Given("the body for addingPlace with {string} {string} {string}")
	 public void the_body_for_addingPlace_with(String name, String Language, String address) throws Throwable {
					
       RequestSpecification requ	=	
    		   given().spec(RequestMethod()).body(data.testData(name, Language, address));
        
    }
	 @When("User send the {string} from {string} method")
	 public void user_send_the_from_method(String resource, String httpMethod) {
        
    	APIResources resourceAPI=APIResources.valueOf(resource);
    	System.out.println(resourceAPI.getResource());
    	
    	if(httpMethod.equalsIgnoreCase("Post"))
    	 resp= requ.when().post(resourceAPI.getResource());
    	else if(httpMethod.equalsIgnoreCase("get"))
    		resp= requ.when().get(resourceAPI.getResource());
    	
    }

	 @Then("API call should be success and status will be {int}")
	 public void api_call_should_be_success_and_status_will_be(Integer int1) throws Throwable {
      
    	
        Assert.assertEquals(resp.getStatusCode(), 200);
    	
    }

    @And("^\"([^\"]*)\" in response will be \"([^\"]*)\"$")
    public void something_in_response_will_be_something(String KeyValue, String ExpectedValue) throws Throwable {
       
    	String stringRes= resp.asString();
    	JsonPath js= new JsonPath(stringRes);
    	Assert.assertEquals(getJsonPath(resp,KeyValue), ExpectedValue);
    	
    }

    @Then("verify the Placeid created maps to {string} using {string}")
    public void verify_the_Placeid_created_maps_to_using(String Expectedvalue, String Apiname) throws IOException {
    	
        	place_id=getJsonPath(resp, "Place_id");
        	requ =given().spec(RequestMethod()).queryParam("Place_id", place_id);
        	user_send_the_from_method( Apiname, "Get");
        	String actualName=getJsonPath(resp, "name");
        	Assert.assertEquals(actualName, Expectedvalue);
        	
       
    }
    @Given("DeletePlace Payload")
    public void deleteplace_Payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions
       given().spec(RequestMethod()).body(data.deletepayload(place_id));
       
    }
}
