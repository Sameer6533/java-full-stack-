package com.convention.hall.booking.service;

import com.convention.hall.booking.DTO.BookingRequest;
import com.convention.hall.booking.model.Booking;
import com.convention.hall.booking.model.Hall;
import com.convention.hall.booking.model.User;
import com.convention.hall.booking.repository.BookingRepository;
import com.convention.hall.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;


    public Booking createBooking(Long userId, Hall hall, BookingRequest bookingRequest) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setHall(hall);
        booking.setBookingDate(bookingRequest.getBookingDate()); 
        booking.setStartDate(bookingRequest.getStartDate());    
        booking.setEndDate(bookingRequest.getEndDate());        
        booking.setPrice(bookingRequest.getPrice());           
        booking.setUserName(bookingRequest.getUserName());      
        booking.setEmail(bookingRequest.getEmail());            
        booking.setPhone(bookingRequest.getPhone());            

        
        return bookingRepository.save(booking);
    }


   
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
    
   
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();  
    }
}
