package com.ecomm.main.product.service;

import com.ecomm.main.exception.ServiceException;
import com.ecomm.main.product.entity.Product;
import com.ecomm.main.vendor.entity.Vendor;
import com.ecomm.main.vendor.service.VendorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final VendorService vendorService;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, VendorService vendorService) {
        this.productRepo = productRepo;
        this.vendorService = vendorService;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        validateSave(product);
        return productRepo.save(product);
    }

    private void validateSave(Product product) {
        if (product.getName() == null || product.getName().isEmpty()) {
            Map<String, Object> details = Map.of("property_name", "name");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Product name cannot be empty");
        }
        if (product.getDescription() == null || product.getDescription().isEmpty()) {
            Map<String, Object> details = Map.of("property_name", "description");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Product description cannot be empty");
        }
        if (product.getPrice() == null) {
            Map<String, Object> details = Map.of("property_name", "price");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Product description cannot be null");
        }
        if(product.getStock() < 0) {
            Map<String, Object> details = Map.of("property_name", "stock");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Product stock cannot be negative");
        }
        if(product.getVendor() == null || product.getVendor().getId() == null) {
            Map<String, Object> details = Map.of("property_name", "vendor");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Product vendor cannot be null");
        }
        Vendor vendor = vendorService.findById(product.getVendor().getId()).orElse(null);
        if (vendor == null) {
            Map<String, Object> details = Map.of("property_name", "vendor");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Invalid Product vendor");
        }else {
            product.setVendor(vendor);
        }
    }
}
