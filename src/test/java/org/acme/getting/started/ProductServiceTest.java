package org.acme.getting.started;

import org.acme.getting.started.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

}