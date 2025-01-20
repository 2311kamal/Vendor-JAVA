package com.example._02_jpa_db.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example._02_jpa_db.models.Vendor;
import com.example._02_jpa_db.response.Response;
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
    public ResponseEntity<Object> getVendorDetails(@PathVariable("vendor") String vendorId) {
        Vendor vendor = vendorService.getVendor(vendorId);
        return new Response.Builder<Vendor>().message("Vendor fetched seccessfully").data(vendor).status(200).build();

    }

    @PostMapping
    public ResponseEntity<Object> createVendor(@RequestBody Vendor vendor) {
        String result = vendorService.createVendor(vendor);
        return new Response.Builder<Vendor>().data(vendor).message(result).status(201).build();

    }

    @PutMapping
    public ResponseEntity<Object> updateVendor(@RequestBody Vendor vendor) {
        String result = vendorService.updateVendor(vendor);
        return new Response.Builder<Vendor>().data(vendor).message(result).status(201).build();

    }

    @DeleteMapping("{vendor}")
    public ResponseEntity<Object> deleteVendor(@PathVariable("vendor") String vendorId) {
        String result = vendorService.deleteVendor(vendorId);
        return new Response.Builder<Vendor>().message(result).status(200).build();
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllVendors() {
        List<Vendor> list = vendorService.getAllVendors();
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("vendors", list); // Add the list under the "vendors" key

        return new Response.Builder<Map<String, Object>>()
                .data(responseData) // Pass the map to data()
                .message("All vendors fetched successfully")
                .status(200)
                .build();
    }
}
