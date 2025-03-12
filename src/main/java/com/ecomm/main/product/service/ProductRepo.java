package com.ecomm.main.product.service;

import com.ecomm.main.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
