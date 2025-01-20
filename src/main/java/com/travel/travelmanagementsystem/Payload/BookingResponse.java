package com.travel.travelmanagementsystem.Payload;

import com.travel.travelmanagementsystem.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private List<Booking> bookings;
}
