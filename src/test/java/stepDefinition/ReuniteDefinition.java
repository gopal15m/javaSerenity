package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class ReuniteDefinition {
    private static final String URL = "http://testurl/";
    public Response response;
     String authorizationHeader = "token value";

    @Given("I send a request to the ULR {int} to get details")
    public void sendRequest(int id){

        response = SerenityRest.given().contentType("application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", authorizationHeader)
                .when().get(URL + id);
    }

    @Then("the response status code {int}")
    public void verifyStatusCode(int statuscode){
        SerenityRest.restAssuredThat(response -> response.statusCode(statuscode));
    }
}
