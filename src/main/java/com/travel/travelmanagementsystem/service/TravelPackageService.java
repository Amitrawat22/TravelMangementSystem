package com.travel.travelmanagementsystem.service;

import com.travel.travelmanagementsystem.model.TravelPackage;

import java.util.List;

public interface TravelPackageService {

    List<TravelPackage> getAllPackages();

    void createPackage(TravelPackage travelPackage);

    String deletePackage(Long packageId);

    TravelPackage updatePackage(TravelPackage travelPackage, Long packageId);
}
