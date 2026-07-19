package org.example.backendecomproj.service;

import org.example.backendecomproj.model.Product;
import org.example.backendecomproj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return  productRepository.findAll();
    }

    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        if(imageFile != null && !imageFile.isEmpty()) {
            product.setImageName(
                    imageFile.getOriginalFilename()
            );

            product.setImageType(
                    imageFile.getContentType()
            );

            product.setImageData(
                    imageFile.getBytes()
            );
        }

        else {
            product.setImageName(null);
            product.setImageType(null);
            product.setImageData(null);
        }
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) {
        Product existingProduct = getProduct(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setReleaseDate(product.getReleaseDate());
            existingProduct.setAvailable(product.isAvailable());
            // Update image data if a new image is provided
            if (imageFile != null && !imageFile.isEmpty()) {
                try {
                    existingProduct.setImageName(imageFile.getOriginalFilename());
                    existingProduct.setImageType(imageFile.getContentType());
                    existingProduct.setImageData(imageFile.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(int id) {
        Product product = getProduct(id);
        if(product == null){
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepository.searchProducts(keyword);
    }
}
