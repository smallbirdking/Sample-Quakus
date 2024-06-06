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
     * Test the greeting endpoint with a valid user name.
     * @TedAIGenerated 20240606182132
     */
    @Test
    public void testGreetingEndpointWithValidUser() {
        User mockUser = new User();
        mockUser.setName("John");
        Mockito.when(userService.getUser(anyString())).thenReturn(mockUser);
        Mockito.when(greetingService.getGreeting(anyString())).thenReturn("Hello John");

        given()
            .pathParam("name", "John")
            .when().get("/greeting/{name}")
            .then()
                .statusCode(200)
                .body(is("Hello John"));
    }

    /**
     * Test the greeting endpoint with a non-existent user.
     * @TedAIGenerated 20240606182132
     */
    @Test
    public void testGreetingEndpointWithNonExistentUser() {
        Mockito.when(userService.getUser(anyString())).thenReturn(null);

        given()
            .pathParam("name", "Jane")
            .when().get("/greeting/{name}")
            .then()
                .statusCode(200)
                .body(is("User not found"));
    }

    /**
     * Test the register endpoint with a new user.
     * @TedAIGenerated 20240606182132
     */
    @Test
    public void testRegisterEndpoint() {
        User newUser = new User();
        newUser.setName("NewUser");
        newUser.setEmail("newuser@example.com");

        Mockito.when(userService.register(Mockito.any(User.class))).thenReturn(newUser);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(newUser)
            .when().post("/register")
            .then()
                .statusCode(200)
                .body("name", is(newUser.getName()),
                      "email", is(newUser.getEmail()));
    }
}