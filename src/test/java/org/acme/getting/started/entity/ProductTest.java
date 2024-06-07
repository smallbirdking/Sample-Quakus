package org.acme.getting.started.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of {@link Product}.
 * It contains 4 unit test cases.
 */
class ProductTest {

    /**
     * Test setting and getting the ID of the Product.
     * @TedAIGenerated 20240607123646
     */
    @Test
    void testSetAndGetId() {
        Product product = new Product();
        product.setId("testId");
        assertEquals("testId", product.getId());
    }

    /**
     * Test setting and getting the name of the Product.
     * @TedAIGenerated 20240607123646
     */
    @Test
    void testSetAndGetName() {
        Product product = new Product();
        product.setName("testName");
        assertEquals("testName", product.getName());
    }

    /**
     * Test setting and getting the description of the Product.
     * @TedAIGenerated 20240607123646
     */
    @Test
    void testSetAndGetDescription() {
        Product product = new Product();
        product.setDescription("testDescription");
        assertEquals("testDescription", product.getDescription());
    }

    /**
     * Test setting and getting the price of the Product.
     * @TedAIGenerated 20240607123646
     */
    @Test
    void testSetAndGetPrice() {
        Product product = new Product();
        product.setPrice(19.99);
        assertEquals(19.99, product.getPrice());
    }
}