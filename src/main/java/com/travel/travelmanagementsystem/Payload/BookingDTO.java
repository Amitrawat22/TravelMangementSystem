package com.travel.travelmanagementsystem.Payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long bookingId;
    private String bookingDate;
    private String bookingTime;
    private String bookingLocation;
    private Integer price;
    private String bookingStatus;
    private Integer totalPassengers;
}
