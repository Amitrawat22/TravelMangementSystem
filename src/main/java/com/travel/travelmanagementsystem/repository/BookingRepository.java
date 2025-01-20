package com.travel.travelmanagementsystem.repository;

import com.travel.travelmanagementsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
