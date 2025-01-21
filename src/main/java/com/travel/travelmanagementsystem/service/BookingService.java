package com.travel.travelmanagementsystem.service;


import com.travel.travelmanagementsystem.Payload.BookingDTO;
import com.travel.travelmanagementsystem.model.Booking;


public interface BookingService{

    BookingDTO addBooking(Long travelPackageId, Booking booking);
}
