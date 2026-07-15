package org.example.simplewebbackendapp.Service;

import org.example.simplewebbackendapp.Repository.ProductRepo;
import org.example.simplewebbackendapp.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductRepo productRepo;

    // Delegate all product reads to the repository.
    public List<Product> getProducts(){
       return productRepo.findAll();
    }

    // Return one product if it exists.
    public  Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    // Insert a new row or update an existing row.
    public void addProduct(Product product){
        productRepo.save(product);
    }

    // Reuse save() for updates because the entity id is the key.
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    // Delete the row by primary key.
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

}
