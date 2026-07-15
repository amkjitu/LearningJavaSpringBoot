package org.example.backendecomproj.controller;

import org.example.backendecomproj.model.Product;
import org.example.backendecomproj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

//    @RequestMapping("/products")
//    public List<Product> getProducts() {
//        return service.getProducts();
//    }

    // Response Data + Status
    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }


//    @RequestMapping("/products/{id}")
//    public Product getProduct(@PathVariable int id) {
//        return service.getProduct(id);
//    }
//
    // Response + Data
    @RequestMapping("/products/{id}")
    public ResponseEntity<Product> getProductWithResponse(@PathVariable int id) {
        Product product = service.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
