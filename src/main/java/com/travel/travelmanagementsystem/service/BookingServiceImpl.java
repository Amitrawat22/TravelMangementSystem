package com.travel.travelmanagementsystem.service;

import com.travel.travelmanagementsystem.Payload.BookingDTO;
import com.travel.travelmanagementsystem.exceptions.ResourceNotFoundException;
import com.travel.travelmanagementsystem.model.Booking;
import com.travel.travelmanagementsystem.model.TravelPackage;
import com.travel.travelmanagementsystem.repository.BookingRepository;
import com.travel.travelmanagementsystem.repository.TravelPackageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TravelPackageRepository travelPackageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookingDTO addBooking(Long travelPackageId, Booking booking) {
        TravelPackage travelPackage = travelPackageRepository.findById(travelPackageId)
                .orElseThrow(() -> new ResourceNotFoundException("travelPackage", "travelPackageId", travelPackageId));
        booking.setBookingLocation("location");
        booking.setBookingStatus("status");
        booking.setTravelPackage(travelPackage);
        bookingRepository.save(booking);
        return modelMapper.map(booking, BookingDTO.class);
    }
}

