package com.convention.hall.booking.DTO;

import com.convention.hall.booking.model.User;

public class LoginResponseDTO {
    private String message;
    private User user;

   

    public LoginResponseDTO(String message, User user) {
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
