package org.example.simplewebbackendapp.Controller;


import org.example.simplewebbackendapp.Model.Product;
import org.example.simplewebbackendapp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    // Read all products from the service layer.
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    // Read one product by id.
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    // Save a new product.
    @PostMapping("/products")
    public void createProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    // Update an existing product.
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    // Remove a product by id.
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
