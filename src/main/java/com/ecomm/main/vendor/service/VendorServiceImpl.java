package com.ecomm.main.vendor.service;

import com.ecomm.main.exception.ServiceException;
import com.ecomm.main.vendor.entity.Vendor;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepo vendorRepo;

    public VendorServiceImpl(VendorRepo vendorRepo) {
        this.vendorRepo = vendorRepo;
    }

    @Override
    public Vendor save(Vendor vendor) {
        validateSave(vendor);
        return vendorRepo.save(vendor);
    }

    @Override
    public Optional<Vendor> findById(Long id) {
        return vendorRepo.findById(id);
    }

    private void validateSave(Vendor vendor) {
        if(vendor.getName() == null || vendor.getName().isEmpty()) {
            Map<String, Object> details = Map.of("property_name", "name");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Vendor name cannot be empty");
        }
        if(vendor.getAddress() == null || vendor.getAddress().isEmpty()) {
            Map<String, Object> details = Map.of("property_name", "address");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Vendor address cannot be empty");
        }
        if(vendor.getPhone() == null || vendor.getPhone().isEmpty()) {
            Map<String, Object> details = Map.of("property_name", "phone");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Vendor phone cannot be empty");
        }
        if(vendor.getEmail() == null || vendor.getEmail().isEmpty()) {
            Map<String, Object> details = Map.of("property_name", "email");
            throw new ServiceException(HttpStatus.BAD_REQUEST, details, "Vendor email cannot be empty");
        }
    }
}
