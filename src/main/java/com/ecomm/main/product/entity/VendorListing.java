package com.ecomm.main.product.entity;

import com.ecomm.main.vendor.entity.Vendor;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VendorListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    private Double price;

    private Integer stock;

}
