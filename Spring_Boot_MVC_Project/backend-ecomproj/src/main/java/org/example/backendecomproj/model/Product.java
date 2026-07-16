package org.example.backendecomproj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private boolean available;
    private Integer quantity;

    @Column
    private String imageName;
    @Column
    private String imageType;

    @Lob
    @Column
    private byte[] imageData;

    /*
    insert into product (name, description, brand, price, category, release_date, available, quantity)
    values ('Chair', 'RFL Plastic', 'RFL', 300, 'Furniture', '2026-07-15', true, 3);
    */
}
