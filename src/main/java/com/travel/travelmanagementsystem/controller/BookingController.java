package com.travel.travelmanagementsystem.controller;


import com.travel.travelmanagementsystem.Payload.BookingDTO;
import com.travel.travelmanagementsystem.model.Booking;
import com.travel.travelmanagementsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/admin/packages/{travelPackageId}/booking")
    public ResponseEntity<BookingDTO> addBooking(@RequestBody Booking booking, @PathVariable Long travelPackageId) {
        BookingDTO bookingDTO = bookingService.addBooking(travelPackageId, booking);
        return new ResponseEntity<>(bookingDTO, HttpStatus.CREATED);
    }
}

