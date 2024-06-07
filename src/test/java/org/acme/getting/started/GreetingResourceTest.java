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
     * Test the greeting endpoint with an existing user name.
     * @TedAIGenerated 20240607072121
     */
    @Test
    public void testGreetingEndpointWithValidName() {
        String name = "John";
        String expectedGreeting = "Hello, John!";
        User mockUser = new User();
        mockUser.setName(name);
        
        Mockito.when(userService.getUser(name)).thenReturn(mockUser);
        Mockito.when(greetingService.getGreeting(name)).thenReturn(expectedGreeting);
        
        given()
            .when().get("/greeting/" + name)
            .then()
                .statusCode(200)
                .body(is(expectedGreeting));
    }

    /**
     * Test the greeting endpoint with a non-existing user name.
     * @TedAIGenerated 20240607072121
     */
    @Test
    public void testGreetingEndpointWithInvalidName() {
        String name = "Unknown";
        
        Mockito.when(userService.getUser(name)).thenReturn(null);
        
        given()
            .when().get("/greeting/" + name)
            .then()
                .statusCode(200)
                .body(is("User not found"));
    }

    /**
     * Test the register endpoint with a new user.
     * @TedAIGenerated 20240607072121
     */
    @Test
    public void testRegisterEndpoint() {
        User newUser = new User();
        newUser.setName("Alice");
        
        Mockito.when(userService.register(Mockito.any(User.class))).thenReturn(newUser);
        
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(newUser)
            .when().post("/register")
            .then()
                .statusCode(200)
                .body(is(newUser.toString())); // assuming User class has a proper toString() method
    }
}