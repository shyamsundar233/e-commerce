package com.ecomm.main.product.service;

import com.ecomm.main.product.entity.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);

}
