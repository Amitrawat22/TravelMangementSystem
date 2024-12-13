package com.travel.travelmanagementsystem.service;
import com.travel.travelmanagementsystem.Payload.TravelPacakgeResponse;
import com.travel.travelmanagementsystem.Payload.TravelPackageDTO;
import com.travel.travelmanagementsystem.exceptions.APIException;
import com.travel.travelmanagementsystem.exceptions.ResourceNotFoundException;
import com.travel.travelmanagementsystem.model.TravelPackage;
import com.travel.travelmanagementsystem.repository.TravelPackageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelPackageServiceImpl implements TravelPackageService {

//    private List<TravelPackage> travelPackageList  = new ArrayList<>();
//    private long nextId = 1L;

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public TravelPacakgeResponse getAllPackages() {
        List<TravelPackage> travelPackages = travelPackageRepository.findAll();
        if(travelPackages.isEmpty()){
            throw new APIException("Travel package detail are not yet added");
        }

        List<TravelPackageDTO> travelPackageDTOS = travelPackages.stream()
                .map(travelPackage -> modelMapper.map(travelPackage, TravelPackageDTO.class))
                .toList();
        TravelPacakgeResponse travelPackageResponse = new TravelPacakgeResponse();
        travelPackageResponse.setContent(travelPackageDTOS);
        return travelPackageResponse;

    }

    @Override
    public TravelPackageDTO createPackage(TravelPackageDTO travelPackageDTO) {
    //    travelPackage.setId(nextId++);
        TravelPackage travelPackage = modelMapper.map(travelPackageDTO, TravelPackage.class);
        TravelPackage travelPackageFromDB = travelPackageRepository.findBytravelPackageName(travelPackage.getTravelPackageName());
        if(travelPackageFromDB != null) {
            throw new APIException("Category already exists with this " + travelPackage.getTravelPackageName()+" name !!!");
        }
        TravelPackage savedTravelPackage = travelPackageRepository.save(travelPackage);
        return modelMapper.map(savedTravelPackage, TravelPackageDTO.class);
    }
    @Override
    public TravelPackageDTO deletePackage(Long travelPackageId) {
        TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId)
                .orElseThrow(()-> new ResourceNotFoundException("TravelPackage", "TravelPackageId", travelPackageId));
        travelPackageRepository.delete(travelPackage);
        return modelMapper.map(travelPackage, TravelPackageDTO.class);
    }
    @Override
    public TravelPackageDTO updatePackage(TravelPackageDTO travelPackageDTO, Long travelPackageId) {
        TravelPackage savedPackage = travelPackageRepository.findById(travelPackageId)
                        .orElseThrow(()-> new ResourceNotFoundException("TravelPackage", "TravelPackageId", travelPackageId));

        TravelPackage travelPackage = modelMapper.map(travelPackageDTO, TravelPackage.class);
        travelPackageDTO.setTravelPackageId(travelPackageId);
        savedPackage  = travelPackageRepository.save(travelPackage);
        return modelMapper.map(savedPackage, TravelPackageDTO.class);
    }
}
