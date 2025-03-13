package com.ecomm.main.vendor.service;

import com.ecomm.main.vendor.entity.Vendor;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepo vendorRepo;

    public VendorServiceImpl(VendorRepo vendorRepo) {
        this.vendorRepo = vendorRepo;
    }

    @Override
    public Vendor save(Vendor vendor) {
        return vendorRepo.save(vendor);
    }
}
