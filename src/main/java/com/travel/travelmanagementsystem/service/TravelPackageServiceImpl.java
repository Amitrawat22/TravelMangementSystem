package com.travel.travelmanagementsystem.service;
import com.travel.travelmanagementsystem.exceptions.APIException;
import com.travel.travelmanagementsystem.exceptions.ResourceNotFoundException;
import com.travel.travelmanagementsystem.model.TravelPackage;
import com.travel.travelmanagementsystem.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelPackageServiceImpl implements TravelPackageService {

//    private List<TravelPackage> travelPackageList  = new ArrayList<>();
//    private long nextId = 1L;

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    @Override
    public List<TravelPackage> getAllPackages() {
        List<TravelPackage> travelPackages = travelPackageRepository.findAll();
        if(travelPackages.isEmpty()){
            throw new APIException("Travel package detail are not yet added");
        }
        return travelPackages;

    }

    @Override
    public void createPackage(TravelPackage travelPackage) {
    //    travelPackage.setId(nextId++);
        TravelPackage savedTravelPackage = travelPackageRepository.findBytravelPackageName(travelPackage.getTravelPackageName());
        if(savedTravelPackage != null) {
            throw new APIException("Category already exists with this " + savedTravelPackage.getTravelPackageName()+" name !!!");
        }
        travelPackageRepository.save(travelPackage);
    }
    @Override
    public String deletePackage(Long travelPackageId) {
        TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId)
                .orElseThrow(()-> new ResourceNotFoundException("TravelPackage", "TravelPackageId", travelPackageId));
        travelPackageRepository.delete(travelPackage);
        return "category with categoryId " + travelPackageId + " deleted !!";
    }
    @Override
    public TravelPackage updatePackage(TravelPackage travelPackage, Long travelPackageId) {
        TravelPackage savedPackage = travelPackageRepository.findById(travelPackageId)
                        .orElseThrow(()-> new ResourceNotFoundException("TravelPackage", "TravelPackageId", travelPackageId));
        travelPackage.setTravelPackageId(travelPackageId);
        travelPackageRepository.save(travelPackage);
        return savedPackage;
    }
}
