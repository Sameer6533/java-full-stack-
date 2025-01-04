
package com.convention.hall.booking.controller;

import com.convention.hall.booking.DTO.BookingRequest;
import com.convention.hall.booking.model.Booking;

import com.convention.hall.booking.model.Hall;
import com.convention.hall.booking.service.BookingService;
import com.convention.hall.booking.service.HallService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    @Autowired
    private HallService hallService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<Booking> bookHall(@Valid @RequestBody BookingRequest bookingRequest) {
        
        Hall hall = hallService.getHallById(bookingRequest.getHallId()).orElse(null);
        if (hall == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
        }

        
        Booking booking = bookingService.createBooking(
                bookingRequest.getUserId(),
                hall,
                bookingRequest 
        );

       
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }


   
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Booking not found
        }
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getBookingsByUser(userId);
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    

    @GetMapping("/getAllBookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // No bookings found
        }
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

}
