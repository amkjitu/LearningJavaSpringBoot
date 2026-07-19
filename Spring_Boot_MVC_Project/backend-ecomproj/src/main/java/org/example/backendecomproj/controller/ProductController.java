package org.example.backendecomproj.controller;

import org.example.backendecomproj.model.Product;
import org.example.backendecomproj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }


//    @RequestMapping("/products/{id}")
//    public Product getProduct(@PathVariable int id) {
//        return service.getProduct(id);
//    }
//
    // Response + Data
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = service.getProduct(id);
        if(product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart(
                    value="imageFile",
                    required=false
            )
            MultipartFile imageFile

    ) throws IOException {
        try {
            Product createdProduct = service.addProduct(product, imageFile);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
        Product product = service.getProduct(id);
        if(product == null || product.getImageData() == null){
            return ResponseEntity.notFound().build();
        }
        String imageType = product.getImageType();
        MediaType mediaType;

        if(imageType != null){
            mediaType = MediaType.parseMediaType(imageType);
        }
        else{
            mediaType = MediaType.IMAGE_JPEG;
        }
        return ResponseEntity
                .ok()
                .contentType(mediaType)
                .body(product.getImageData());
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestPart("product") Product product,  @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {
        try {
            Product updatedProduct = service.updateProduct(id, product, imageFile);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        try {
            service.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
