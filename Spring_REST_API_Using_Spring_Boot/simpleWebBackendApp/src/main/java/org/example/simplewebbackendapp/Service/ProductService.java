package org.example.simplewebbackendapp.Service;

import lombok.Getter;
import org.example.simplewebbackendapp.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Getter
@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Product 1", 100),
            new Product(102, "Product 2", 200),
            new Product(103, "Product 3", 300)
    ));

    public List<Product> getProducts(){ // if we use lombok.Getter; so we don't need to define this method
       return products;
    }

    public  Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void updateProduct(Product product) {
        int index = 0;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId() == product.getId()){
                index=i;
            }
        }
        products.set(index, product);
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
