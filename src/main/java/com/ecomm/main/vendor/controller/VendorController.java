package com.ecomm.main.vendor.controller;

import com.ecomm.main.api.APIController;
import com.ecomm.main.exception.ServiceException;
import com.ecomm.main.vendor.entity.Vendor;
import com.ecomm.main.vendor.entity.VendorDTO;
import com.ecomm.main.vendor.service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
public class VendorController extends APIController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping("/vendor")
    public ResponseEntity<Response> createVendor(@RequestBody VendorDTO data) {
        try{
            Vendor vendor = vendorService.getEntityDataFromDTO(List.of(data)).get(0);
            vendor = vendorService.save(vendor);
            Map<String, Object> details = Map.of("id", vendor.getId().toString());
            addResponse(HttpStatus.CREATED, "Vendor Created Successfully", details);
            return response();
        } catch (Exception e) {
            HttpStatus code = e instanceof ServiceException ? ((ServiceException) e).code : HttpStatus.BAD_REQUEST;
            Map<String, Object> details = e instanceof ServiceException ? ((ServiceException) e).details : null;
            addResponse(code, e.getMessage(), details);
            return response();
        }
    }

}
