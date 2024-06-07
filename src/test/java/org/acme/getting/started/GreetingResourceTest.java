package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.acme.getting.started.entity.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;

@QuarkusTest
/**
 * Test class of {@link GreetingResource}.
 * It contains 3 unit test cases.
 */
class GreetingResourceTest {

    @InjectMock
    GreetingService greetingService;

    @InjectMock
    UserService userService;

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    /**
     * Test greeting endpoint with an existing user.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testGreetingWithExistingUser() {
        User user = new User();
        user.setName("Alice");
        Mockito.when(userService.getUser(anyString())).thenReturn(user);
        Mockito.when(greetingService.getGreeting(anyString())).thenReturn("Hello, Alice!");

        given()
                .when().get("/greeting/Alice")
                .then()
                .statusCode(200)
                .body(is("Hello, Alice!"));
    }

    /**
     * Test greeting endpoint with a non-existing user.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testGreetingWithNonExistingUser() {
        Mockito.when(userService.getUser(anyString())).thenReturn(null);

        given()
                .when().get("/greeting/Bob")
                .then()
                .statusCode(200)
                .body(is("User not found"));
    }

    /**
     * Test registering a new user.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testRegisterUser() {
        User newUser = new User();
        newUser.setName("Charlie");
        newUser.setEmail("charlie@example.com");

        Mockito.when(userService.register(Mockito.any(User.class))).thenReturn(newUser);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(newUser)
                .when().post("/register")
                .then()
                .statusCode(200)
                .body("name", is("Charlie"),
                      "email", is("charlie@example.com"));
    }
}