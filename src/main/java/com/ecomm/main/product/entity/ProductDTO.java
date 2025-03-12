package com.ecomm.main.product.entity;

import lombok.Data;

@Data
public class ProductDTO {

    private String id;

    private String name;

    private String description;

    private String price;

    private String stock;

    private String vendorId;

}
