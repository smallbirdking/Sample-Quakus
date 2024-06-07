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
     * Test updating a product in the ProductService.
     * @TedAIGenerated 20240607035319
     */
    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setId("p1");
        product.setName("Product 1 Updated");
        product.setDescription("Description of Product 1 Updated");
        product.setPrice(12.0);

        productService.addProduct(product); // Adding the product first
        Product updatedProduct = new Product();
        updatedProduct.setId("p1");
        updatedProduct.setName("Product 1 New Name");
        updatedProduct.setDescription("New Description");
        updatedProduct.setPrice(15.0);

        Product result = productService.updateProduct("p1", updatedProduct);

        assertNotNull(result);
        assertEquals("p1", result.getId());
        assertEquals("Product 1 New Name", result.getName());
        assertEquals("New Description", result.getDescription());
        assertEquals(15.0, result.getPrice());
    }

    /**
     * Test getting a product by ID that exists in the ProductService.
     * @TedAIGenerated 20240607035319
     */
    @Test
    public void testGetProductExists() {
        Product product = new Product();
        product.setId("p2");
        product.setName("Product 2");
        product.setDescription("Description of Product 2");
        product.setPrice(20.0);

        productService.addProduct(product);

        Product result = productService.getProduct("p2");

        assertNotNull(result);
        assertEquals("p2", result.getId());
        assertEquals("Product 2", result.getName());
        assertEquals("Description of Product 2", result.getDescription());
        assertEquals(20.0, result.getPrice());
    }

    /**
     * Test getting a product by ID that does not exist in the ProductService.
     * @TedAIGenerated 20240607035319
     */
    @Test
    public void testGetProductNotExists() {
        Product result = productService.getProduct("p3");
        assertNull(result);
    }
}