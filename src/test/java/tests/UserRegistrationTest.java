package tests;

import com.github.javafaker.Faker;
import common.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import payloadBuilder.PayloadBuilder;
import requestBuilder.ApiRequestBuilder;
import utils.PayloadStore;
import utils.Requests;
import utils.TestListener;

@Listeners(TestListener.class)
public class UserRegistrationTest extends BaseTest {

    private final Faker faker = new Faker();

    private String password = faker.internet().password(8, 12, true, false, true) + "@";
    private String email = faker.internet().emailAddress();
    private String adminToken;
    private String userId;
    private String adminEmail = "testdummy@email.co.za";
    private String adminPassword = "testdummy@email.co.za";

    @Test(priority = 1)
    public void createUser() {

        test.get().info("Creating new user");

        Response response = ApiRequestBuilder.post(
                "/register",
                PayloadBuilder.registerUser(email, password)
        );

        response.then().statusCode(201);

        userId = response.jsonPath().getString("data.id");

        Assert.assertNotNull(userId);

        test.get().pass("User created with ID: " + userId);
    }

    @Test(priority = 2, dependsOnMethods = "createUser")
    public void adminLogin() {

        test.get().info("Logging in as admin");

        adminToken = Requests.getToken(adminEmail, adminPassword);

        Assert.assertNotNull(adminToken);

        test.get().pass("Admin logged in successfully");
    }

    @Test(priority = 3, dependsOnMethods = "adminLogin")
    public void approveUser() {

        test.get().info("Approving user");

        ApiRequestBuilder.putWithAuth(
                "/admin/users/" + userId + "/approve",
                adminToken
        ).then().statusCode(200);

        test.get().pass("User approved successfully");
    }

    @Test(priority = 4, dependsOnMethods = "approveUser")
    public void makeUserAdmin() {

        test.get().info("Making user admin");

        ApiRequestBuilder.putWithAuth(
                "/admin/users/" + userId + "/role",
                adminToken,
                PayloadStore.makeAdminRole
        ).then().statusCode(200);

        test.get().pass("User role updated to admin");
    }

    @Test(priority = 5, dependsOnMethods = "makeUserAdmin")
    public void loginAsNewUser() {

        test.get().info("Logging in as new user");

        String userToken = Requests.getToken(email, password);

        Assert.assertNotNull(userToken);

        test.get().pass("New user logged in successfully");
    }

    @Test(priority = 6, dependsOnMethods = "loginAsNewUser")
    public void verifyUserIsAdmin() {

        test.get().info("Verifying user role");

        String userToken = Requests.getToken(email, password);

        Response response = ApiRequestBuilder.getWithAuth(
                "/admin/users/" + userId,
                userToken
        );

        String role = response.jsonPath().getString("data.Role");

        Assert.assertTrue(role.toLowerCase().contains("admin"));

        test.get().pass("User verified as admin");
    }

    @Test(priority = 7, dependsOnMethods = "verifyUserIsAdmin")
    public void deleteUser() {

        test.get().info("Deleting user");

        ApiRequestBuilder.deleteWithAuth(
                "/admin/users/" + userId,
                adminToken
        ).then().statusCode(200);

        test.get().pass("User deleted successfully");
    }
}