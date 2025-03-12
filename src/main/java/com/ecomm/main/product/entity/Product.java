package com.ecomm.main.product.entity;

import com.ecomm.main.vendor.entity.Vendor;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor = new Vendor();

}
