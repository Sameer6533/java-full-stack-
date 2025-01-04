package com.convention.hall.booking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall hall;

    @NotNull
    private LocalDateTime bookingDate;  
    private String userName;
    private String email;
    private String phone;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price; 
    
    public Booking() {}

    // Constructor with user, hall, and bookingDate
    public Booking(User user, Hall hall, LocalDateTime bookingDate, 
                   String userName, String email, String phone,
                   LocalDateTime startDate, LocalDateTime endDate, BigDecimal price) {
        this.user = user;
        this.hall = hall;
        this.bookingDate = bookingDate;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    // New getter and setter methods for the additional fields
    public String getUserName() {
        return userName != null ? userName : (user != null ? user.getName() : null); // You may replace user.getName() with the actual method in your User class
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email != null ? email : (user != null ? user.getEmail() : null); // Replace user.getEmail() with the actual method in your User class
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone != null ? phone : (user != null ? user.getMobileNumber() : null); // Replace user.getPhone() with the actual method in your User class
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}