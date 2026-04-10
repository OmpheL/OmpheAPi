package requestBuilder;

import common.BaseURIs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiRequestBuilder {

    public static Response post(String endpoint, String body) {
        return given()
                .baseUri(BaseURIs.BASE_URL)
                .header("Content-Type", "application/json")
                .body(body)
                .post(endpoint);
    }

    public static Response putWithAuth(String endpoint, String token) {
        return given()
                .baseUri(BaseURIs.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .put(endpoint);
    }

    public static Response putWithAuth(String endpoint, String token, String body) {
        return given()
                .baseUri(BaseURIs.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(body)
                .put(endpoint);
    }

    public static Response getWithAuth(String endpoint, String token) {
        return given()
                .baseUri(BaseURIs.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .get(endpoint);
    }

    public static Response deleteWithAuth(String endpoint, String token) {
        return given()
                .baseUri(BaseURIs.BASE_URL)
                .header("Authorization", "Bearer " + token)
                .delete(endpoint);
    }
}