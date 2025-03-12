package com.ecomm.main.vendor.service;

import com.ecomm.main.vendor.entity.Vendor;
import com.ecomm.main.vendor.entity.VendorDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface VendorService {

    Vendor save(Vendor vendor);

    Optional<Vendor> findById(Long id);

    default List<Vendor> getEntityDataFromDTO(List<VendorDTO> vendorDTOList) {
        List<Vendor> vendorList = new ArrayList<>();
        for (VendorDTO vendorDTO : vendorDTOList) {
            Vendor vendor = new Vendor();
            vendor.setId(vendorDTO.getId() == null ? null : Long.parseLong(vendorDTO.getId()));
            vendor.setName(vendorDTO.getName());
            vendor.setAddress(vendorDTO.getAddress());
            vendor.setPhone(vendorDTO.getPhone());
            vendor.setEmail(vendorDTO.getEmail());
            vendorList.add(vendor);
        }
        return vendorList;
    }

    default List<VendorDTO> getDTODataFromEntity(List<Vendor> vendorList) {
        List<VendorDTO> vendorDTOList = new ArrayList<>();
        for (Vendor vendor : vendorList) {
            VendorDTO vendorDTO = new VendorDTO();
            vendorDTO.setId(vendor.getId().toString());
            vendorDTO.setName(vendor.getName());
            vendorDTO.setAddress(vendor.getAddress());
            vendorDTO.setPhone(vendor.getPhone());
            vendorDTO.setEmail(vendor.getEmail());
            vendorDTOList.add(vendorDTO);
        }
        return vendorDTOList;
    }

}
