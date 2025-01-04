package com.convention.hall.booking.repository;

import com.convention.hall.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);  // Find all bookings for a user

}
