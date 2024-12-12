package com.travel.travelmanagementsystem.repository;

import com.travel.travelmanagementsystem.model.TravelPackage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
    TravelPackage findBytravelPackageName(String travelPackageName);

//jpa repo that is been injected in travel package service adn proiding its methods likwe get all

}


