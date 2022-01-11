package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class ReuniteDefinition {
    private static final String URL = "http://testurl/";
    public Response response;
     String authorizationHeader = "eyJraWQiOiJCN29Vb2x2R1NyRW52QU9CYTJ5VWJUa0ZsamZuaUl5R1JIRmVJWmRFeDZFPSIsImFsZyI6IlJTMjU2In0.eyJvcmlnaW5fanRpIjoiNTY1YTYyMWEtYzMyMi00MDQ5LTg2MzgtMmNmMDEwZjVmMzY0Iiwic3ViIjoiNGU3NjZjNmItYTg2Yi00ZWMzLTkxN2MtZGZiNmNhNjg4NGRiIiwiYXVkIjoiMjIwamxhNnFpZm4yZm9yNXJpamt1dXB2cnUiLCJjb2duaXRvOmdyb3VwcyI6WyJwZXRpdGlvbmVyIl0sImV2ZW50X2lkIjoiOGYwMDAyOTctZDc1Mi00OTk1LTgyNDQtNjAwY2M5MGFkNDU1IiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2NDE5MzU5MjEsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTIuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0yX3pDSlpEcENjQyIsImNvZ25pdG86dXNlcm5hbWUiOiJ0ZXN0LXBldGl0aW9uZXIiLCJleHAiOjE2NDE5Mzk1MjEsImlhdCI6MTY0MTkzNTkyMSwianRpIjoiZDdkZjAzNDItY2U2ZC00MTVkLTliNTktOWE4NmIzYzUwMTIyIn0.bK4l7mCfRLCl6KZ-e20DLBI7vFJW-4-lR-5PzSDU6Jat1jODykpUAfqM9xpXEER3lpeH4N0Rxr5Z5LgfizSerRjBITYkb2-ykoJCcJiMDcjAA2XIwUXr5EGP7mn-F_iXM1qccZyFGcgHFSj4r71AgrrGKMIotAAlwFCFFPlzT6hF2ZpypcTsP_A0L21sQE2bLkYRS_oPXNgKH2Bw2mkbHrqkF6hmmYdEgvVS45cfcMmZhInJ5qkCeVlBmDNaEiw_i3821CrZUodGHEwS8gg-oFV4T2GTUgr0t_QGLfx7_WkLnvkZT59uqL3Nvhu3LsH9crVGH7L0ONagwMqJtqJs7A";

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
