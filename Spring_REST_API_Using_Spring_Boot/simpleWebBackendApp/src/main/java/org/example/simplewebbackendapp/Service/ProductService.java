package org.example.simplewebbackendapp.Service;

import org.example.simplewebbackendapp.Model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = Arrays.asList(
            new Product(101, "Product 1", 100),
            new Product(102, "Product 2", 200),
            new Product(103, "Product 3", 300)
    );

    public List<Product> getProducts() {
        return products;
    }
}
