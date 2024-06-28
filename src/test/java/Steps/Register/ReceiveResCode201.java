package Steps.Register;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static org.junit.Assert.assertEquals;


public class ReceiveResCode201 {

    public Response response;
    public int ResponseCode;

    @Then("i receive the response code as 201")
    public void IReceiveTheResponseCodeAs201(){

        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());
        ResponseCode =response.getStatusCode();
//        assertEquals(ResponseCode, 201);
    }
}
