package com.example._02_jpa_db.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example._02_jpa_db.models.Vendor;
import com.example._02_jpa_db.service.VendorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("{vendor}")
    public Vendor getVendorDetails(@PathVariable("vendor") String vendorId) {
        return vendorService.getVendor(vendorId);
    }

    @PostMapping
    public String createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);

    }

    @PutMapping
    public String updateVendor(@RequestBody Vendor vendor) {
        return vendorService.updateVendor(vendor);

    }

    @DeleteMapping("{vendor}")
    public String deleteVendor(@PathVariable("vendor") String vendorId) {
        return vendorService.deleteVendor(vendorId);
    }

    @GetMapping("/all")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
}







