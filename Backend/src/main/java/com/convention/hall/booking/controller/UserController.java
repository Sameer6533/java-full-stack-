package com.convention.hall.booking.controller;

import com.convention.hall.booking.DTO.LoginDTO;
import com.convention.hall.booking.model.User;
import com.convention.hall.booking.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200") 
public class UserController {

    @Autowired
    
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody User user) {
        if (userService.findUserByEmail(user.getEmail()).isPresent()) {

        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
             	    .body(new ApiResponse("Email is already Registered"));

        }
        userService.saveUser(user); 

        return ResponseEntity.status(HttpStatus.CREATED)
        	    .body(new ApiResponse("User registered successfully."));

    }
      
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody LoginDTO loginDTO) {
        ApiResponse apiResponse = userService.validateUser(loginDTO); 

        
        if (apiResponse.getUser() != null) {
        	
            return ResponseEntity.status(HttpStatus.OK).body(apiResponse);  
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);  
        }
    }
    
    
    

}
