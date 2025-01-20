package com.example._02_jpa_db.service;

import java.util.List;

import com.example._02_jpa_db.models.Vendor;

public interface VendorService {
    public String createVendor(Vendor vendor);

    public String updateVendor(Vendor vendor);

    public String deleteVendor(String vendorId);

    public Vendor getVendor(String vendorId);

    public List<Vendor> getAllVendors();
}








