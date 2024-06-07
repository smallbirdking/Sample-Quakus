package org.acme.getting.started.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of {@link User}.
 * It contains 4 unit test cases.
 */
class UserTest {

    /**
     * Test creating a new User instance.
     * @TedAIGenerated 20240607123646
     */
    @Test
    void testUserConstructor() {
        User user = new User("1", "testuser", "password123");
        assertNotNull(user);
        assertEquals("1", user.getId());
        assertEquals("testuser", user.getUsername());
        assertEquals("password123", user.getPassword());
    }

    /**
     * Test setting and getting the user's ID.
     * @TedAIGenerated 20240607123646
     */
    @Test
    void testSetAndGetId() {
        User user = new User("1", "testuser", "password123");
        user.setId("2");
        assertEquals("2", user.getId());
    }

    /**
     * Test setting and getting the user's username.
     * @TedAIGenerated 20240607123646
     */
    @Test
    void testSetAndGetUsername() {
        User user = new User("1", "testuser", "password123");
        user.setUsername("newusername");
        assertEquals("newusername", user.getUsername());
    }

    /**
     * Test setting and getting the user's password.
     * @TedAIGenerated 20240607123646
     */
    @Test
    void testSetAndGetPassword() {
        User user = new User("1", "testuser", "password123");
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }
}