package com.ecomm.main.product.service;

import com.ecomm.main.product.entity.Product;
import com.ecomm.main.product.entity.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {

    default List<Product> getEntityDataFromDTO(List<ProductDTO> productDTOs){
        List<Product> productList = new ArrayList<>();
        for (ProductDTO dto : productDTOs) {
            Product data = new Product();
            data.setId(dto.getId() == null ? null : Long.parseLong(dto.getId()));
            data.setName(dto.getName());
            data.setDescription(dto.getDescription());
            data.setPrice(Double.parseDouble(dto.getPrice()));
            data.setStock(Integer.parseInt(dto.getStock()));
            if(dto.getVendorId() != null && !dto.getVendorId().isEmpty()) {
                data.getVendor().setId(Long.parseLong(dto.getVendorId()));
            }
            productList.add(data);
        }
        return productList;
    }

    default List<ProductDTO> getDTODataFromEntity(List<Product> products){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product data : products) {
            ProductDTO dto = new ProductDTO();
            dto.setId(data.getId() == null ? null : data.getId().toString());
            dto.setName(data.getName());
            dto.setDescription(data.getDescription());
            dto.setPrice(data.getPrice().toString());
            dto.setStock(data.getStock().toString());
            dto.setVendorId(data.getVendor().getId().toString());
            productDTOList.add(dto);
        }
        return productDTOList;
    }

    List<Product> getAllProducts();

    Product saveProduct(Product product);

}
