package Steps.Register;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;

public class PassUrlSSO {

    public RequestSpecification httpRequest;
    public Response response;

    public static String getRandomMail(){
        String upperCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCharacters = "abcdefghijklmnopqrstuvwxyz";
        String numberCharacters = "0123456789";
        return RandomStringUtils.random(3, lowerCharacters)
                + RandomStringUtils.random(3, upperCharacters)
                + RandomStringUtils.random(3, numberCharacters)
                + System.currentTimeMillis()
                + "@gmail.com";
    }

    @When("i pass the url of the sso auth in the request")
    public void IPassTheUrlOfTheSsoAuthInTheRequest(){
        httpRequest = RestAssured.given()
                .formParam("Email", getRandomMail())
                .formParam("Password", "Example123*")
                .formParam("Fullname", "Exampe 123");
        response = httpRequest.post("/api/v1/register?oauth=true");
    }
}
