package org.acme.getting.started;

import org.acme.getting.started.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** 
 * Test class of {@link ProductService}. 
 * It contains 4 unit test cases.  
 */ 
class ProductServiceTest {

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
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setId("p2");
        product.setName("Product 2");
        product.setDescription("Description of Product 2");
        product.setPrice(20.0);

        productService.addProduct(product);

        Product updatedProduct = new Product();
        updatedProduct.setId("p2");
        updatedProduct.setName("Product 2 Updated");
        updatedProduct.setDescription("Updated Description of Product 2");
        updatedProduct.setPrice(25.0);

        Product result = productService.updateProduct("p2", updatedProduct);

        assertNotNull(result);
        assertEquals("Product 2 Updated", result.getName());
        assertEquals("Updated Description of Product 2", result.getDescription());
        assertEquals(25.0, result.getPrice());
    }

    /**
     * Test getting an existing product by ID in the ProductService.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testGetProduct() {
        Product product = new Product();
        product.setId("p3");
        product.setName("Product 3");
        product.setDescription("Description of Product 3");
        product.setPrice(30.0);

        productService.addProduct(product);

        Product result = productService.getProduct("p3");

        assertNotNull(result);
        assertEquals("p3", result.getId());
        assertEquals("Product 3", result.getName());
        assertEquals("Description of Product 3", result.getDescription());
        assertEquals(30.0, result.getPrice());
    }

    /**
     * Test getting a product by ID that does not exist in the ProductService.
     * @TedAIGenerated 20240607123646
     */
    @Test
    public void testGetNonExistentProduct() {
        Product result = productService.getProduct("p4");

        assertNull(result);
    }
}