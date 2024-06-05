package org.acme.getting.started;

import org.acme.getting.started.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class ProductService {
    private Map<String, Product> products = new HashMap<>();

    public Product addProduct(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    public Product updateProduct(String id, Product product) {
        // In a real-world application, you should handle cases where the product does not exist
        products.put(id, product);
        return product;
    }

    public Product getProduct(String id) {
        return products.get(id);
    }
}