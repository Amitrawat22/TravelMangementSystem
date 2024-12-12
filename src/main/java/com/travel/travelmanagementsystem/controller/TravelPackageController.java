package com.travel.travelmanagementsystem.controller;

import com.travel.travelmanagementsystem.model.TravelPackage;
import com.travel.travelmanagementsystem.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelPackageController {

    @Autowired
    private TravelPackageService packageService;

    @RequestMapping(value = "/public/packages",method = RequestMethod.GET)
    public ResponseEntity<List<TravelPackage>> getAllPackages() {
        List<TravelPackage> packages = packageService.getAllPackages();
        return new ResponseEntity<>(packages, HttpStatus.OK);
    }
    @RequestMapping(value = "/public/packages",method = RequestMethod.POST)
    public ResponseEntity<String> createPackage(@RequestBody TravelPackage travelPackage) {
        packageService.createPackage(travelPackage);
        return new ResponseEntity<>("category added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/packages/{travelPackageId}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePackage(@PathVariable Long travelPackageId) {

            String status = packageService.deletePackage(travelPackageId);
            return new ResponseEntity<>(status, HttpStatus.OK);

    }
    @RequestMapping(value ="/public/packages/{travelPackageId}",method = RequestMethod.PUT)
    public ResponseEntity<String> updatePackage(@RequestBody TravelPackage travelPackage,
                                                @PathVariable Long travelPackageId)
    {
            TravelPackage savedTravelPackage = packageService.updatePackage(travelPackage,travelPackageId);
            return new ResponseEntity<>("Category updated with category id: " + travelPackageId , HttpStatus.OK);
    }
}
