package org.example.simplewebbackendapp.Controller;


import org.example.simplewebbackendapp.Model.Product;
import org.example.simplewebbackendapp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
