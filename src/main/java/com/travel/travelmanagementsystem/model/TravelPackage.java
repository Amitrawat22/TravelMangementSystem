package com.travel.travelmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "packages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_PACKAGE_ID")
    private Long travelPackageId;

    @NotBlank
    @Size(min = 1,message = "Name must contain atleast 5 characters")
    @Column(name = "NAME")// Maps to the database column
    private String travelPackageName;

    @NotBlank
    @Column(name = "START_DATE") // Maps to the database column
    private String startDate;

    @NotBlank
    @Column(name = "END_DATE") // Maps to the database column
    private String endDate;

    @NotBlank
    @Column(name = "DESTINATION") // Maps to the database column
    private String destination;


}


