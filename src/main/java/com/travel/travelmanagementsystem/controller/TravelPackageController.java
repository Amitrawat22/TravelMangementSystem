package com.travel.travelmanagementsystem.controller;

import com.travel.travelmanagementsystem.Payload.TravelPacakgeResponse;
import com.travel.travelmanagementsystem.Payload.TravelPackageDTO;
import com.travel.travelmanagementsystem.config.AppConstants;
import com.travel.travelmanagementsystem.model.TravelPackage;
import com.travel.travelmanagementsystem.service.TravelPackageService;
import jakarta.validation.Valid;
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
    public ResponseEntity<TravelPacakgeResponse> getAllPackages(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(name = "sortBy",defaultValue = AppConstants.SORT_TRAVELPACKAGES_BY,required = false) String sortBy,
            @RequestParam(name = "sortOrder",defaultValue = AppConstants.SORT_DIR,required = false) String sortOrder
    ) {
        TravelPacakgeResponse travelPacakgeResponse = packageService.getAllPackages(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(travelPacakgeResponse, HttpStatus.OK);
    }
    @RequestMapping(value = "/public/packages",method = RequestMethod.POST)
    public ResponseEntity<TravelPackageDTO> createPackage(@Valid @RequestBody TravelPackageDTO travelPackageDTO) {
        TravelPackageDTO savedTravelPackageDTO  = packageService.createPackage(travelPackageDTO);
        return new ResponseEntity<>(savedTravelPackageDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/admin/packages/{travelPackageId}",method = RequestMethod.DELETE)
    public ResponseEntity<TravelPackageDTO> deletePackage(@PathVariable Long travelPackageId) {

            TravelPackageDTO deletedPackage = packageService.deletePackage(travelPackageId);
            return new ResponseEntity<>(deletedPackage, HttpStatus.OK);

    }
    @RequestMapping(value ="/public/packages/{travelPackageId}",method = RequestMethod.PUT)
    public ResponseEntity<TravelPackageDTO> updatePackage(@Valid @RequestBody TravelPackageDTO travelPackageDTO,
                                                @PathVariable Long travelPackageId)
    {
            TravelPackageDTO savedTravelPackageDTO = packageService.updatePackage(travelPackageDTO,travelPackageId);
            return new ResponseEntity<>(savedTravelPackageDTO , HttpStatus.OK);
    }
}
