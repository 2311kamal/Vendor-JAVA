package com.example._02_jpa_db.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example._02_jpa_db.exception.VendorNotFoundException;
import com.example._02_jpa_db.models.Vendor;
import com.example._02_jpa_db.repository.VendorRepository;
import com.example._02_jpa_db.service.VendorService;

@Service
public class VendorImpl implements VendorService {
    private VendorRepository vendorRepository;

    public VendorImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public String createVendor(Vendor vendor) {
        vendorRepository.save(vendor);
        return "Vendor created successfully";
    }

    @Override
    public String updateVendor(Vendor vendor) {
        vendorRepository.save(vendor);
        return "Vendor updated successfully";
    }

    @Override
    public String deleteVendor(String vendorId) {
        vendorRepository.deleteById(vendorId);
        return "Vendor deleted successfully";
    }

    @Override
    public Vendor getVendor(String vendorId) {
        return vendorRepository.findById(vendorId)
                .orElseThrow(() -> new VendorNotFoundException("Vendor with ID " + vendorId + " doesn't exist"));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

}
