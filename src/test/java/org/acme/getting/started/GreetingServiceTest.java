package org.acme.getting.started;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class of {@link GreetingService}.
 * It contains 2 unit test cases.
 */
class GreetingServiceTest {

    /**
     * Test the getGreeting method with a non-empty name.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testGetGreetingWithNonEmptyName() {
        GreetingService greetingService = new GreetingService();
        String name = "John";
        String expectedGreeting = "hello John";
        String actualGreeting = greetingService.getGreeting(name);
        assertEquals(expectedGreeting, actualGreeting, "The greeting message should be 'hello John'.");
    }

    /**
     * Test the getGreeting method with an empty name.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testGetGreetingWithEmptyName() {
        GreetingService greetingService = new GreetingService();
        String name = "";
        String expectedGreeting = "hello ";
        String actualGreeting = greetingService.getGreeting(name);
        assertEquals(expectedGreeting, actualGreeting, "The greeting message should be 'hello '.");
    }
}