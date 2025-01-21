package com.travel.travelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;
    private String bookingDate;
    private long bookingPrice;
    private String bookingLocation;
    private String bookingStatus;
    private int numberOfPassengers;

    @ManyToOne
    @JoinColumn(name = "travelPackage_id")
    private TravelPackage travelPackage;


}
