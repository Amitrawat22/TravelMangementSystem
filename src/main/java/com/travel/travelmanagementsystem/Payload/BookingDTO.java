package com.travel.travelmanagementsystem.Payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private long bookingId;
    private String bookingDate;
    private long bookingPrice;
    private String bookingLocation;
    private String bookingStatus;
    private int numberOfPassengers;
}
