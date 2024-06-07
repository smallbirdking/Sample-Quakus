package org.acme.getting.started;

import org.acme.getting.started.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of {@link UserService}.
 * It contains 4 unit test cases.
 */
class UserServiceTest {
    
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testRegister() {
        User newUser = new User("3", "newUser", "password");
        User result = userService.register(newUser);
        assertEquals(newUser, result);
        assertNotNull(userService.getUser("newUser"));
    }

    @Test
    public void testLoginSuccess() {
        User user = userService.login("wang", "123");
        assertNotNull(user);
        assertEquals("1", user.getId());
        assertEquals("wang", user.getUsername());
    }

    @Test
    public void testLoginFailure() {
        User user = userService.login("wang", "wrongPassword");
        assertNull(user);
    }

    @Test
    public void testGetUserExisting() {
        User user = userService.getUser("wang");
        assertNotNull(user);
        assertEquals("1", user.getId());
        assertEquals("wang", user.getUsername());
    }

    @Test
    public void testGetUserNonExisting() {
        User user = userService.getUser("nonExistingUser");
        assertNull(user);
    }

    /**
     * Test registering a user that already exists in the UserService.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testRegisterExistingUser() {
        User existingUser = new User("4", "wang", "newPassword");
        User result = userService.register(existingUser);
        // Assuming UserService does not have logic to prevent registering with an existing username,
        // the test will expect the user to be replaced in the map.
        assertEquals(existingUser, result);
        // Verify the user in the service has the new password.
        assertEquals("newPassword", userService.getUser("wang").getPassword());
    }

    /**
     * Test login with a username that does not exist in the UserService.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testLoginNonExistingUsername() {
        User user = userService.login("nonExisting", "123");
        assertNull(user);
    }
}