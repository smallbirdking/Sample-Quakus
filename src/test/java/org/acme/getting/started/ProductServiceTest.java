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
     * @TedAIGenerated 20240607072121
     */
    @Test
    public void testUpdateProduct_ExistingProduct() {
        Product product = new Product();
        product.setId("p1");
        product.setName("Product 1");
        product.setDescription("Description of Product 1");
        product.setPrice(10.0);

        productService.addProduct(product);

        Product updatedProduct = new Product();
        updatedProduct.setId("p1");
        updatedProduct.setName("Updated Product 1");
        updatedProduct.setDescription("Updated description of Product 1");
        updatedProduct.setPrice(15.0);

        Product result = productService.updateProduct("p1", updatedProduct);

        assertNotNull(result);
        assertEquals("p1", result.getId());
        assertEquals("Updated Product 1", result.getName());
        assertEquals("Updated description of Product 1", result.getDescription());
        assertEquals(15.0, result.getPrice());
    }

    /**
     * Test updating a non-existing product in the ProductService.
     * @TedAIGenerated 20240607072121
     */
    @Test
    public void testUpdateProduct_NonExistingProduct() {
        Product updatedProduct = new Product();
        updatedProduct.setId("p2");
        updatedProduct.setName("New Product 2");
        updatedProduct.setDescription("Description of New Product 2");
        updatedProduct.setPrice(20.0);

        Product result = productService.updateProduct("p2", updatedProduct);

        assertNotNull(result);
        assertEquals("p2", result.getId());
        assertEquals("New Product 2", result.getName());
        assertEquals("Description of New Product 2", result.getDescription());
        assertEquals(20.0, result.getPrice());
    }

    /**
     * Test getting an existing product by ID from the ProductService.
     * @TedAIGenerated 20240607072121
     */
    @Test
    public void testGetProduct_ExistingId() {
        Product product = new Product();
        product.setId("p1");
        product.setName("Product 1");
        product.setDescription("Description of Product 1");
        product.setPrice(10.0);

        productService.addProduct(product);

        Product result = productService.getProduct("p1");

        assertNotNull(result);
        assertEquals("p1", result.getId());
        assertEquals("Product 1", result.getName());
        assertEquals("Description of Product 1", result.getDescription());
        assertEquals(10.0, result.getPrice());
    }

    /**
     * Test getting a product by ID that does not exist in the ProductService.
     * @TedAIGenerated 20240607072121
     */
    @Test
    public void testGetProduct_NonExistingId() {
        Product result = productService.getProduct("p3");

        assertNull(result);
    }
}