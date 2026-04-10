package utils;

import io.restassured.response.Response;
import payloadBuilder.PayloadBuilder;
import requestBuilder.ApiRequestBuilder;

public class Requests {

    public static String getToken(String email, String password) {

        Response response = ApiRequestBuilder.post(
                "/login",
                PayloadBuilder.login(email, password)
        );

        return response.jsonPath().getString("data.token");
    }
}