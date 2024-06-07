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
public class GreetingResourceTest {

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
     * @TedAIGenerated 20240607035319
     */
    @Test
    public void testGreetingEndpointWithValidUser() {
        User mockUser = new User();
        mockUser.setName("John");

        Mockito.when(userService.getUser(anyString())).thenReturn(mockUser);
        Mockito.when(greetingService.getGreeting(anyString())).thenReturn("Hello, John!");

        given()
                .when().get("/greeting/John")
                .then()
                .statusCode(200)
                .body(is("Hello, John!"));
    }

    /**
     * Test the greeting endpoint with an invalid user name.
     * @TedAIGenerated 20240607035319
     */
    @Test
    public void testGreetingEndpointWithInvalidUser() {
        Mockito.when(userService.getUser(anyString())).thenReturn(null);

        given()
                .when().get("/greeting/unknown")
                .then()
                .statusCode(200)
                .body(is("User not found"));
    }

    /**
     * Test the register endpoint with a valid user.
     * @TedAIGenerated 20240607035319
     */
    @Test
    public void testRegisterEndpointWithValidUser() {
        User userToRegister = new User();
        userToRegister.setName("Jane");
        userToRegister.setEmail("jane@example.com");

        Mockito.when(userService.register(Mockito.any(User.class))).thenReturn(userToRegister);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userToRegister)
                .when().post("/register")
                .then()
                .statusCode(200)
                .body(is("{\"name\":\"Jane\",\"email\":\"jane@example.com\"}"));
    }
}