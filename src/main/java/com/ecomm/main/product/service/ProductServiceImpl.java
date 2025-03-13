package com.ecomm.main.product.service;

import com.ecomm.main.product.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
}
