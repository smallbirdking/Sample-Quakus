package org.acme.getting.started;

import org.acme.getting.started.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of {@link ProductService}.
 * It contains 4 unit test cases.
 */
public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setId("p1");
        product.setName("Product 1");
        product.setDescription("Description of Product 1");
        product.setPrice(10.0);

        Product result = productService.addProduct(product);

        assertEquals(product, result);
    }

    /**
     * Test updating an existing product in the ProductService.
     * @TedAIGenerated 20240606182132
     */
    @Test
    public void testUpdateProduct() {
        // Add a product first
        Product product = new Product();
        product.setId("p2");
        product.setName("Product 2");
        product.setDescription("Description of Product 2");
        product.setPrice(20.0);
        productService.addProduct(product);

        // Update the product
        Product updatedProduct = new Product();
        updatedProduct.setId("p2");
        updatedProduct.setName("Updated Product 2");
        updatedProduct.setDescription("Updated Description of Product 2");
        updatedProduct.setPrice(25.0);
        Product result = productService.updateProduct("p2", updatedProduct);

        assertNotNull(result);
        assertEquals("Updated Product 2", result.getName());
        assertEquals("Updated Description of Product 2", result.getDescription());
        assertEquals(25.0, result.getPrice());
    }

    /**
     * Test getting a product by its ID from the ProductService.
     * @TedAIGenerated 20240606182132
     */
    @Test
    public void testGetProduct() {
        // Add a product first
        Product product = new Product();
        product.setId("p3");
        product.setName("Product 3");
        product.setDescription("Description of Product 3");
        product.setPrice(30.0);
        productService.addProduct(product);

        // Get the product by ID
        Product result = productService.getProduct("p3");

        assertNotNull(result);
        assertEquals("Product 3", result.getName());
        assertEquals("Description of Product 3", result.getDescription());
        assertEquals(30.0, result.getPrice());
    }

    /**
     * Test getting a non-existing product by its ID from the ProductService.
     * @TedAIGenerated 20240606182132
     */
    @Test
    public void testGetNonExistingProduct() {
        // Try to get a product that has not been added
        Product result = productService.getProduct("non_existing_id");

        assertNull(result);
    }
}