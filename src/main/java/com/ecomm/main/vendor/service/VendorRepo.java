package com.ecomm.main.vendor.service;

import com.ecomm.main.vendor.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor, Long> {
}
