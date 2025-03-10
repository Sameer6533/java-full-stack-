package com.convention.hall.booking.controller;

import com.convention.hall.booking.model.User;

public class ApiResponse {

    private String message;
    private User user; 

    public ApiResponse(String message) {
        this.message = message;
        this.user = null;
    }

    public ApiResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
