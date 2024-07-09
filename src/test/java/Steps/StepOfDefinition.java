package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.json.JSONArray;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import io.restassured.specification.RequestSpecification;
import java.io.File;



public class StepOfDefinition {

    private Response response;
    private JSONObject requestBody;
    private static int postId;
    private static String Token;

    // Initiation

    @Given("User set API endpoint")
    public void user_set_post_api_endpoint() {
        RestAssured.baseURI = "http://35.208.89.94:8080";
    }

    // Login

    @When("User send POST HTTPS Request using valid Email and Password")
    public void user_send_post_https_request_using_valid_email_and_password() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "fazri.egi@binar.co.id");
        requestBody.put("password", "Coba123!");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/login?type=app");

        String token = response.jsonPath().getString("data.token");
        TokenManager.setToken("token_Account_1", token);
        assertNotNull(TokenManager.getToken("token_Account_1"));

    }

    @When("User send POST HTTPS Request using Wrong Format Email and Password")
    public void user_send_post_https_request_using_wrong_format_email_and_password(){
        requestBody = new JSONObject();
        requestBody.put("email", "egimail.com");
        requestBody.put("password", "coba123123");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/login?type=app");
    }

    @When("User send POST HTTPS Request using SSO Email")
    public void user_send_post_https_request_using_sso_email(){
        requestBody = new JSONObject();
        requestBody.put("email", "fazri.egi@binar.co.id");
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/login?type=sso");
    }

    @When("User send POST HTTPS Request using Wrong Unregistered Email and Password")
    public void user_send_post_https_request_using_wrong_email_and_password(){
        requestBody = new JSONObject();
        requestBody.put("email", "egi@mail.com");
        requestBody.put("password", "fazri.egi@binar.co.id");
        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/login?type=app");
    }

    @When("User send POST HTTPS Request Without Input Email and Password")
    public void user_send_post_https_without_input_email_and_password(){
        requestBody = new JSONObject();

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/login?type=app");
    }

    // Reset Password Send To Email

    @When("User send POST HTTPS Request using valid Email To Reset Password")
    public void user_send_post_https_request_using_valid_email_to_reset_password(){
        requestBody = new JSONObject();
        requestBody.put("email", "fazri.egi@binar.co.id");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/email/reset-password");
    }

    @When("User send POST HTTPS Request using invalid Email To Reset Password")
    public void user_send_post_https_request_using_invalid_email_to_reset_password(){
        requestBody = new JSONObject();
        requestBody.put("email", "egi@mail.com");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/email/reset-password");
    }

    @When("User send POST HTTPS Request without input Email for Reset Password")
    public void user_send_post_https_request_without_input_email_for_reset_password(){
        requestBody = new JSONObject();

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/reset-password");
    }

    // Reset Password About Input Password

    @When("User send POST HTTPS Request using invalid password To Reset Password")
    public void user_send_post_https_request_using_invalid_password_to_reset_password(){
        requestBody = new JSONObject();
        requestBody.put("email", "Example5@gmail.com");
        requestBody.put("password", "123");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/reset-password");
    }

    @When("User send POST HTTPS Request using valid password To Reset Password")
    public void user_send_post_https_request_using_valid_password_to_reset_password(){
        requestBody = new JSONObject();
        requestBody.put("email", "Example5@gmail.com");
        requestBody.put("password", "Egi123123@");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/reset-password");
    }

    @When("User send POST HTTPS Request To Reset Password Without Input Email and Password")
    public void user_send_post_https_request_to_reset_password_without_input_email_and_password(){
        requestBody = new JSONObject();

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/reset-password");
    }

    @When("User send POST HTTPS Request To Reset Password Without input Email")
    public void user_send_post_https_request_to_reset_password_without_input_email(){
        requestBody = new JSONObject();
        requestBody.put("password", "Egi123123@");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/reset-password");
    }

    @When("User send POST HTTPS Request To Reset Password Without input Password")
    public void user_send_post_https_request_to_reset_password_without_input_password(){
        requestBody = new JSONObject();
        requestBody.put("email", "Example5@gmail.com");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/reset-password");
    }

    //Send Reset Password To Email

    @When("User send POST HTTPS For Send Link Reset Password With Valid Email")
    public void User_send_POST_HTTPS_For_Send_Link_Reset_Password_With_Valid_Email(){
        requestBody = new JSONObject();
        requestBody.put("email", "fazri.egi@binar.co.id");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/email/reset-password");
    }

    @When("User send POST HTTPS For Send Link Reset Password With Unregistered Email")
    public void User_send_POST_HTTPS_For_Send_Link_Reset_Password_With_Unregistered_Email(){
        requestBody = new JSONObject();
        requestBody.put("email", "test@example.com");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/email/reset-password");
    }

    @When("User send POST HTTPS For Send Link Reset Password Without Input Email")
    public void User_send_POST_HTTPS_For_Send_Link_Reset_Password_Without_Input_Email(){
        requestBody = new JSONObject();
        requestBody.put("email", " ");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/email/reset-password");
    }

    //Follow Recommendations

    @When("User send Get HTTPS Request For Follow Recommendations Without Login")
    public void user_send_get_https_request_for_follow_Recommendations_without_login(){
        RequestSpecification request = RestAssured.given();
        String url = baseURI + "/api/v1/users/me/follow-recommendations?page=1&limit=5";
        response = request.get(url);
    }

    @When("User send Get HTTPS Request For Follow Recommendations With Login")
    public void user_send_get_https_request_for_follow_Recommendations_with_login(){
        RequestSpecification request = RestAssured.given().header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"));
        String url = baseURI + "/api/v1/users/me/follow-recommendations?page=1&limit=5";
        response = request.get(url);
    }

    @When("User send Get HTTPS Request For Follow Recommendations")
    public void user_send_get_https_request_for_follow_Recommendations(){

        RequestSpecification request = RestAssured.given();
        String url = baseURI + "/api/v1/users/me/follow-recommendations?page=1&limit=5";
        response = request.get(url);
    }

    //Follow Unfollow USer
    @When("User send Post HTTPS Request For Follow Another User")
    public void User_send_Post_HTTPS_Request_For_Follow_Another_User_No_Auth(){

        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/2/follow");
    }

    @When("User send Post HTTPS Request For Follow Another User No Auth")
    public void User_send_Post_HTTPS_Request_For_Follow_Another_User(){

        response = given()
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/2/follow");
    }

    @When("User send Delete HTTPS Request For Unfollow Another User")
    public void User_send_Delete_HTTPS_Request_For_Unfollow_Another_User(){

        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .delete(RestAssured.baseURI + "/api/v1/users/2/follow");
    }

    @When("User send Delete HTTPS Request For Unfollow Another User No Auth")
    public void User_send_Delete_HTTPS_Request_For_Unfollow_Another_User_No_Auth(){

        response = given()
                .when()
                .delete(RestAssured.baseURI + "/api/v1/users/2/follow");
    }

    // Post User Login

    // Create Post
    @When("User send POST HTTPS Request For Create New Post")
    public void user_send_post_https_request_for_create_new_post(){
        requestBody = new JSONObject();
        requestBody.put("title", "coba upload");
        requestBody.put("visibility", "public");
        requestBody.put("content", "upload");

        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " +  TokenManager.getToken("token_Account_1"))
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/me/posts/");

        postId = response.jsonPath().getInt("data.id");
        System.out.println(postId);
    }

    @When("User send POST HTTPS Request For Create New Post Without Login")
    public void user_send_post_https_request_for_create_new_post_without_login(){
        requestBody = new JSONObject();
        requestBody.put("title", "coba upload");
        requestBody.put("visibility", "public");
        requestBody.put("content", "upload");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/me/posts/");
    }

    @When("User send POST HTTPS Request For Create New Post Validation Error")
    public void user_send_post_https_request_for_create_new_post_validation_error(){
        requestBody = new JSONObject();
        requestBody.put("title", "coba upload");

        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/me/posts/");
    }

    //Comment Post

    @When("User send POST HTTPS Request For Comment Post")
    public void user_send_post_https_request_for_comment_post(){
        File gambar = new File("D:\\Binar\\Binar Labs\\Profiln\\QA\\API Automation\\Github Profiln API Automation\\APIAutomation\\src\\test\\Image\\2.jpg");
        response = given()
                .multiPart("content", "coba Comment")
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))

                .contentType("multipart/form-data; boundary=<calculated when request is sent>")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/5/comments");
        if (!gambar.exists()) {
            throw new RuntimeException("File not found: " + gambar.getAbsolutePath());
        }else{
            System.out.println("File Path: " + gambar.getPath());
            System.out.println("File Name: " + gambar.getName());
            System.out.println("File Absolute Path: " + gambar.getAbsolutePath());
            System.out.println("File Size (bytes): " + gambar.length());
            String fileName = gambar.getName();
            String fileExtension = "";
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0) {
                fileExtension = fileName.substring(dotIndex + 1);
            }
            System.out.println("File Extension: " + fileExtension);
        }
    }

    @When("User send POST HTTPS Request For Comment Post Validation Error")
    public void user_send_post_https_request_for_comment_post_validation_error(){
        response = given()
                .multiPart("files", " ")
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments");
    }

    @When("User send POST HTTPS Request For Comment Post Wrong Format File")
    public void user_send_post_https_request_for_comment_post_wrong_format_file(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("content", "coba Comment")
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments");
    }

    @When("User send POST HTTPS Request For Comment Post Many Files")
    public void user_send_post_https_request_for_comment_post_many_files(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("content", "coba Comment")
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments");
    }

    @When("User send POST HTTPS Request For Comment Post Large Size")
    public void user_send_post_https_request_for_comment_post_large_size(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/1.jpg");
        response = given()
                .multiPart("content", "coba Comment")
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments");
    }

    @When("User send POST HTTPS Request For Comment Post Data Not Found")
    public void user_send_post_https_request_for_comment_post_data_not_found(){

        response = given()
                .multiPart("content", "coba Comment")

                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/99/comments");
    }

    //Replay Comment

    @When("User send POST HTTPS Request For Replay Comment")
    public void user_send_post_https_request_for_replay_comment(){
//        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("content", "coba Comment buat comment")
//                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments/1/replies");
    }

    @When("User send POST HTTPS Request For Replay Comment Validation Error")
    public void user_send_post_https_request_for_replay_comment_validation_error(){
        response = given()
                .multiPart("files", " ")
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments/1/replies");
    }

    @When("User send POST HTTPS Request For Replay Comment Wrong Format")
    public void user_send_post_https_request_for_replay_comment_wrong_format(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/Dokumen/Test Plan.docx");
        response = given()
                .multiPart("content", "coba Comment buat comment")
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments/1/replies");
    }

    @When("User send POST HTTPS Request For Replay Comment Many Files")
    public void user_send_post_https_request_for_replay_comment_many_files(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("content", "coba Comment")
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments/1/replies");
    }

    @When("User send POST HTTPS Request For Replay Comment Large Size")
    public void user_send_post_https_request_for_replay_comment_large_size(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/1.jpg");
        response = given()
                .multiPart("content", "coba Comment")
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments/1/replies");
    }

    @When("User send POST HTTPS Request For Replay Comment Not Found")
    public void user_send_post_https_request_for_replay_comment_not_found(){
//        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/1.jpg");
        response = given()
                .multiPart("content", "coba Comment")
//                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/99/comments/99/replies");
    }

    @When("User send POST HTTPS Request For Replay Comment No Auth")
    public void user_send_post_https_request_for_replay_comment_no_auth(){
//        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/1.jpg");
        response = given()
                .multiPart("content", "coba Comment")
//                .multiPart("files", gambar)
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/1/comments/1/replies");
    }

    // Report Post

    @When("User send POST HTTPS Request For Report Post")
    public void user_send_post_https_request_for_report_post(){
        requestBody = new JSONObject();

        JSONArray reasons = new JSONArray();
        reasons.put("spam");
        reasons.put("kekerasan");

        requestBody.put("reason", reasons);
        requestBody.put("message", "Konten ditampilkan berulang-ulang");

        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/report");
    }

    @When("User send POST HTTPS Request For Report Post Validation Error")
    public void user_send_post_https_request_for_report_post_validation_error(){
        requestBody = new JSONObject();

        requestBody.put("message", "Konten ditampilkan berulang-ulang");

        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/report");
    }

    @When("User send POST HTTPS Request For Report Post No Auth")
    public void User_send_POST_HTTPS_Request_For_Report_Post_No_Auth(){
        requestBody = new JSONObject();
        JSONArray reasons = new JSONArray();
        reasons.put("spam");
        reasons.put("kekerasan");

        requestBody.put("reason", reasons);
        requestBody.put("message", "Konten ditampilkan berulang-ulang");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/report");
    }

    // Like Post

    @When("User send POST HTTPS Request For Like Post")
    public void User_send_POST_HTTPS_Request_For_Like_Post(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/like");
    }

    @When("User send POST HTTPS Request For Like Post Not Found")
    public void User_send_POST_HTTPS_Request_For_Like_Post_Not_Found(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/99/like");
    }

    @When("User send POST HTTPS Request For Like Post No Auth")
    public void User_send_POST_HTTPS_Request_For_Like_Post_No_Auth(){
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/like");
    }

    // Unlike Post

    @When("User send DELETE HTTPS Request For Unlike Post")
    public void User_send_DELETE_HTTPS_Request_For_Unlike_Post(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .delete(RestAssured.baseURI + "/api/v1/posts/3/like");
    }

    @When("User send DELETE HTTPS Request For Unlike Post Not Found")
    public void User_send_DELETE_HTTPS_Request_For_Unlike_Post_Not_Found(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .delete(RestAssured.baseURI + "/api/v1/posts/99/like");
    }

    @When("User send DELETE HTTPS Request For Unlike Post No Auth")
    public void User_send_DELETE_HTTPS_Request_For_Unlike_Post_No_Auth(){
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(RestAssured.baseURI + "/api/v1/posts/3/like");
    }

    // Like Post Comment

    @When("User send POST HTTPS Request For Like Post Comment")
    public void User_send_POST_HTTPS_Request_For_Like_Post_Comment(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments/3/like");
    }

    @When("User send POST HTTPS Request For Like Post Not Found Comment")
    public void User_send_POST_HTTPS_Request_For_Like_Post_Not_Found_Comment(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/99/comments/99/like");
    }

    @When("User send POST HTTPS Request For Like Post No Auth Comment")
    public void User_send_POST_HTTPS_Request_For_Like_Post_No_Auth_Comment(){
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/comments/3/like");
    }

    // Unlike Post Comment

    @When("User send DELETE HTTPS Request For Unlike Post Comment")
    public void User_send_DELETE_HTTPS_Request_For_Unlike_Post_Comment(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .delete(RestAssured.baseURI + "/api/v1/posts/3/comments/3/like");
    }

    @When("User send DELETE HTTPS Request For Unlike Post Not Found Comment")
    public void User_send_DELETE_HTTPS_Request_For_Unlike_Post_Not_Found_Comment(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .delete(RestAssured.baseURI + "/api/v1/posts/99/comments/99/like");
    }

    @When("User send DELETE HTTPS Request For Unlike Post No Auth Comment")
    public void User_send_DELETE_HTTPS_Request_For_Unlike_Post_No_Auth_Comment(){
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(RestAssured.baseURI + "/api/v1/posts/3/comments/3/like");
    }

    // Update Post

    @When("User send PATCH HTTPS Request For Update Post")
    public void User_send_PATCH_HTTPS_Request_For_Update_Post(){
        requestBody = new JSONObject();
        requestBody.put("title", "coba update");
        requestBody.put("visibility", "public");
        requestBody.put("content", "upload");

        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .body(requestBody.toString())
                .when()
                .patch(RestAssured.baseURI + "/api/v1/users/me/posts/3");
    }

    @When("User send PATCH HTTPS Request For Update Post No Auth")
    public void User_send_PATCH_HTTPS_Request_For_Update_Post_No_Auth(){
        requestBody = new JSONObject();
        requestBody.put("title", "coba update");
        requestBody.put("visibility", "public");
        requestBody.put("content", "upload");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .patch(RestAssured.baseURI + "/api/v1/users/me/posts/3");
    }

    @When("User send PATCH HTTPS Request For Update Post Not Found")
    public void User_send_PATCH_HTTPS_Request_For_Update_Post_Not_Found(){
        requestBody = new JSONObject();
        requestBody.put("title", "coba update");
        requestBody.put("visibility", "public");
        requestBody.put("content", "upload");

        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .body(requestBody.toString())
                .when()
                .patch(RestAssured.baseURI + "/api/v1/users/me/posts/9999");
    }

    // Repost Post

    @When("User send POST HTTPS Request For Repost Post")
    public void User_send_POST_HTTPS_Request_For_Repost_Post(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Example0.2125969508634724@gmail.com");
        requestBody.put("password", "Example123*");

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post(RestAssured.baseURI + "/api/v1/login?type=app");

        String token = response.jsonPath().getString("data.token");
        TokenManager.setToken("token_Account_2", token);
        assertNotNull(TokenManager.getToken("token_Account_2"));
        
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_2"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/repost");
    }

    @When("User send POST HTTPS Request For Repost Post Not Found")
    public void User_send_POST_HTTPS_Request_For_Repost_Post_Not_Found(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_2"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/99999/repost");
    }

    @When("User send POST HTTPS Request For Repost Post No Author")
    public void User_send_POST_HTTPS_Request_For_Repost_Post_No_Author(){
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/repost");
    }

    @When("User send POST HTTPS Request For Repost Self Post")
    public void User_send_POST_HTTPS_Request_For_Repost_Self_Post(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/repost");
    }

    // Unrepost Post

    @When("User send POST HTTPS Request For Unrepost")
    public void User_send_POST_HTTPS_Request_For_Unrepost(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_2"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/unrepost");
    }

    @When("User send POST HTTPS Request For Unrepost No Author")
    public void User_send_POST_HTTPS_Request_For_Unrepost_No_Author(){
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/3/unrepost");
    }

    @When("User send POST HTTPS Request For Unrepost Not Found")
    public void User_send_POST_HTTPS_Request_For_Unrepost_Not_Found(){
        response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_2"))
                .when()
                .post(RestAssured.baseURI + "/api/v1/posts/999999/unrepost");
    }

    // image uploads for create post

    @When("User send POST HTTPS Request For Upload Image For Create Post")
    public void User_send_POST_HTTPS_Request_For_Upload_Image_For_Create_Post(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/me/posts/3/upload");
    }

    @When("User send POST HTTPS Request For Create New Post Not Found")
    public void User_send_POST_HTTPS_Request_For_Create_New_Post_Not_Found(){
        response = given()
                .multiPart("files", "")
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/me/posts/999999999/upload");
    }

    @When("User send POST HTTPS Request For Create New Post Many Image")
    public void User_send_POST_HTTPS_Request_For_Create_New_Post_Many_Image(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/me/posts/3/upload");
    }

    @When("User send POST HTTPS Request For Create New Post Large Size File")
    public void User_send_POST_HTTPS_Request_For_Create_New_Post_Large_Size_File(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/1.jpg");
        response = given()
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/me/posts/3/upload");
    }

    @When("User send POST HTTPS Request For Create New Post Wrong Format")
    public void User_send_POST_HTTPS_Request_For_Create_New_Post_Wrong_Format(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/Dokumen/Test Plan.docx");
        response = given()
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .post(RestAssured.baseURI + "/api/v1/users/me/posts/3/upload");
    }

    // Image Update For Update Post

    @When("User send PUT HTTPS Request For Upload Image For Create Post")
    public void User_send_PUT_HTTPS_Request_For_Upload_Image_For_Create_Post(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .put(RestAssured.baseURI + "/api/v1/users/me/posts/3/upload");
    }

    @When("User send PUT HTTPS Request For Create New Post Not Found")
    public void User_send_PUT_HTTPS_Request_For_Create_New_Post_Not_Found(){
//        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("files", "")
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .put(RestAssured.baseURI + "/api/v1/users/me/posts/9999999/upload");
    }

    @When("User send PUT HTTPS Request For Create New Post Many Image")
    public void User_send_PUT_HTTPS_Request_For_Create_New_Post_Many_Image(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/2.jpg");
        response = given()
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .put(RestAssured.baseURI + "/api/v1/users/me/posts/3/upload");
    }

    @When("User send PUT HTTPS Request For Create New Post Large Size File")
    public void User_send_PUT_HTTPS_Request_For_Create_New_Post_Large_Size_File(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/API Automation/Image/1.jpg");
        response = given()
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .put(RestAssured.baseURI + "/api/v1/users/me/posts/3/upload");
    }

    @When("User send PUT HTTPS Request For Create New Post Wrong Format")
    public void User_send_PUT_HTTPS_Request_For_Create_New_Post_Wrong_Format(){
        File gambar = new File("D:/Binar/Binar Labs/Profiln/QA/Dokumen/Test Plan.docx");
        response = given()
                .multiPart("files", gambar)
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .contentType("multipart/form-data")
                .when()
                .put(RestAssured.baseURI + "/api/v1/users/me/posts/3/upload");
    }

    //Delete Post

    @When("User send DELETE HTTPS Request For Delete Post")
    public void User_send_DELETE_HTTPS_Request_For_Delete_Post(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .delete(RestAssured.baseURI + "/api/v1/users/me/posts/" + postId);
        System.out.println("/api/v1/users/me/posts/" + postId);
    }

    @When("User send DELETE HTTPS Request For Delete Post Not Found")
    public void User_send_DELETE_HTTPS_Request_For_Delete_Post_Not_Found(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .delete(RestAssured.baseURI + "/api/v1/users/me/posts/99999");
    }

    @When("User send DELETE HTTPS Request For Delete Post No Auth")
    public void User_send_DELETE_HTTPS_Request_For_Delete_Post_No_Auth(){
        response = given()
                .when()
                .delete(RestAssured.baseURI + "/api/v1/users/me/posts/2");
    }

    // User Get All

    @When("User send Get HTTPS Request For Get All")
    public void User_send_Get_HTTPS_Request_For_Get_All(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .queryParam("orderBy", "newest")
                .when()
                .get(RestAssured.baseURI + "/api/v1/posts");
    }

    @When("User send Get HTTPS Request For Get All No Auth")
    public void User_send_Get_HTTPS_Request_For_Get_All_No_Auth(){
        response = given()
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .queryParam("orderBy", "newest")
                .when()
                .get(RestAssured.baseURI + "/api/v1/posts");
    }

    @When("User send Get HTTPS Request For Get All Post Comment")
    public void User_send_Get_HTTPS_Request_For_Get_All_Post_Comment(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .when()
                .get(RestAssured.baseURI + "/api/v1/posts/3/comments");
    }

    @When("User send Get HTTPS Request For Get All Post Comment No Auth")
    public void User_send_Get_HTTPS_Request_For_Get_All_Post_Comment_No_Auth(){
        response = given()
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .when()
                .get(RestAssured.baseURI + "/api/v1/posts/3/comments");
    }

    @When("User send Get HTTPS Request For Get All Detail Post")
    public void User_send_Get_HTTPS_Request_For_Get_All_Detail_Post(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .get(RestAssured.baseURI + "/api/v1/posts/2");
    }

    @When("User send Get HTTPS Request For Get All Detail Post Not Found")
    public void User_send_Get_HTTPS_Request_For_Get_All_Detail_Post_Not_Found(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .when()
                .get(RestAssured.baseURI + "/api/v1/posts/999999");
    }

    @When("User send Get HTTPS Request For Get All Reply")
    public void User_send_Get_HTTPS_Request_For_Get_All_Reply(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .when()
                .get(RestAssured.baseURI + "/api/v1/posts/19/comments/23/replies");
    }

    @When("User send Get HTTPS Request For Get All Reply No Auth")
    public void User_send_Get_HTTPS_Request_For_Get_All_Reply_No_Auth(){
        response = given()
                .queryParam("page", "1")
                .queryParam("limit", "10")
                .when()
                .get(RestAssured.baseURI + "/api/v1/posts/19/comments/23/replies");
    }

    @When("User send Get HTTPS Request For Get All Post By User ID")
    public void User_send_Get_HTTPS_Request_For_Get_All_Post_By_User_ID(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .queryParam("page", "1")
                .queryParam("limit", "5")
                .when()
                .get(RestAssured.baseURI + "/api/v1/users/2/posts/repost");
    }

    @When("User send Get HTTPS Request For Get All Post By User ID No Auth")
    public void User_send_Get_HTTPS_Request_For_Get_All_Post_By_User_ID_No_Auth(){
        response = given()
                .queryParam("page", "1")
                .queryParam("limit", "5")
                .when()
                .get(RestAssured.baseURI + "/api/v1/users/2/posts/repost");
    }

    @When("User send Get HTTPS Request For Get All By User ID")
    public void User_send_Get_HTTPS_Request_For_Get_All_By_User_ID(){
        response = given()
                .header("Authorization", "Bearer " + TokenManager.getToken("token_Account_1"))
                .queryParam("page", "1")
                .queryParam("limit", "5")
                .when()
                .get(RestAssured.baseURI + "/api/v1/users/1/posts/like");
    }

    @When("User send Get HTTPS Request For Get All By User ID No Auth")
    public void User_send_Get_HTTPS_Request_For_Get_All_By_User_ID_No_Auth(){
        response = given()
                .queryParam("page", "1")
                .queryParam("limit", "5")
                .when()
                .get(RestAssured.baseURI + "/api/v1/users/1/posts/like");
    }

    //Message

    @Then("User receive Success Message")
    public void user_receive_success_message(){
        System.out.println("Response Body: " + response.asString());
        String message = response.jsonPath().getString("status.message");
        System.out.println("Message: " + message);
        assertNotNull("The message should not be null", message);
        assertTrue(message,"Success login".equals(message) || "Success".equals(message) || "Success reset password".equals(message)
                            ||"Success get follows recommendations".equals(message) || "Success create post".equals(message)
                            || "Success create post comment".equals(message) || "Success create post comment reply".equals(message)
                            || "Success report post".equals(message) || "Success like post".equals(message) || "Success unlike post".equals(message)
                            || "Success unlike post comment".equals(message) || "Success like post comment".equals(message) || "Success update post".equals(message)
                            || "Success repost post".equals(message) || "Success unrepost post".equals(message) || "Success add post images".equals(message)
                            || "Success fetch posts".equals(message) || "Success get post comments".equals(message) || "Success get detail post".equals(message)
                            || "Success get post comment replies".equals(message) || "Success get user's posts".equals(message) || "success".equals(message)
                            || "Success delete post".equals(message) || "Success follow user".equals(message) || "Success unfollow user".equals(message));
    }

    @Then("User receive Error Message")
    public void user_receive_error_message(){
        System.out.println("Response Body: " + response.asString());
        String message = response.jsonPath().getString("status.message");
        System.out.println("Message: " + message);
        assertNotNull("The message should not be null", message);
        assertTrue(message,"Validation error".equals(message) || "Incorrect email or password!".equals(message) || "Email not found".equals(message)
                        || "Sign in to proceed".equals(message) || "File format not allowed. Allowed formats are: [.png .jpg]".equals(message)
                        || "Too many files. Maximum allowed is 1 files".equals(message) || "Data not found".equals(message) || "Can't repost own post".equals(message)
                        || "Too many files. Maximum allowed is 10 files".equals(message));
    }

    @Then("User receive HTTP response code {int}")
    public void user_receive_http_response_code(Integer statusCode) {
        response.then().statusCode(statusCode);
        System.out.println("Status Code :" + statusCode);
    }




}
