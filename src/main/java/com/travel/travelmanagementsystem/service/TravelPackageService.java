package com.travel.travelmanagementsystem.service;

import com.travel.travelmanagementsystem.Payload.TravelPacakgeResponse;
import com.travel.travelmanagementsystem.Payload.TravelPackageDTO;
import com.travel.travelmanagementsystem.model.TravelPackage;

import java.util.List;

public interface TravelPackageService {

    TravelPacakgeResponse getAllPackages();

    TravelPackageDTO createPackage(TravelPackageDTO travelPackageD);

    TravelPackageDTO deletePackage(Long packageId);

    TravelPackageDTO updatePackage(TravelPackageDTO travelPackageDTO, Long packageId);
}
