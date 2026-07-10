package stellarburgers.client;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import stellarburgers.model.User;

import static io.restassured.RestAssured.given;
import static stellarburgers.Endpoints.*;

public class UserClient {

    private static final String BASE_URI = "https://stellarburgers.education-services.ru";

    public UserClient() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Step("Register user via API")
    public Response register(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(REGISTER);
    }

    @Step("Login user via API")
    public Response login(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(LOGIN);
    }

    @Step("Delete user via API")
    public void delete(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .when()
                .delete(USER);
    }

}
