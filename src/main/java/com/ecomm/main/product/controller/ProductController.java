package com.ecomm.main.product.controller;

import com.ecomm.main.api.APIController;
import com.ecomm.main.exception.ServiceException;
import com.ecomm.main.product.entity.Product;
import com.ecomm.main.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
public class ProductController extends APIController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Response> createProduct(@RequestBody Product data) {
        try{
            data = productService.saveProduct(data);
            Map<String, Object> map = Map.of("id", data.getId().toString());
            addResponse(HttpStatus.OK, "Product created successfully", map);
            return response();
        } catch (Exception e) {
            HttpStatus code = e instanceof ServiceException ? ((ServiceException) e).code : HttpStatus.BAD_REQUEST;
            Map<String, Object> details = e instanceof ServiceException ? ((ServiceException) e).details : null;
            addResponse(code, e.getMessage(), details);
            return response();
        }
    }

    @GetMapping("/product")
    public ResponseEntity<Response> getProducts() {
        try{
            List<Product> productList = productService.getAllProducts();
            Map<String, Object> map = Map.of("products", productList);
            addResponse(HttpStatus.OK, "Products list", map);
            return response();
        } catch (Exception e) {
            HttpStatus code = e instanceof ServiceException ? ((ServiceException) e).code : HttpStatus.BAD_REQUEST;
            Map<String, Object> details = e instanceof ServiceException ? ((ServiceException) e).details : null;
            addResponse(code, e.getMessage(), details);
            return response();
        }
    }

}
