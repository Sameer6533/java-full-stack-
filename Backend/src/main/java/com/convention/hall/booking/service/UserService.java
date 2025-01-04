package com.convention.hall.booking.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.convention.hall.booking.DTO.LoginDTO;
import com.convention.hall.booking.DTO.LoginResponseDTO;
import com.convention.hall.booking.controller.ApiResponse;
import com.convention.hall.booking.model.User;
import com.convention.hall.booking.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
   @Autowired
    UserRepository userRepository;
  public User saveUser(User user) {
 return userRepository.save(user);
}
  

  public ApiResponse validateUser(LoginDTO loginDTO) {
      Optional<User> optionalUser = findUserByEmail(loginDTO.getEmail());
      if (!optionalUser.isPresent()) {
          return new ApiResponse("User Not Found");
      } else {
          User user = optionalUser.get();
          if (user.getPassword().equalsIgnoreCase(loginDTO.getPassword())) {
            
              return new ApiResponse("User Logged In Successfully", user);
          } else {
              return new ApiResponse("Bad Credentials. Password mismatched");
          }
      }
  }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);  
    }
    
  
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
    
    public boolean existsById(Long userId) {
        return userRepository.existsById(userId);
    }
    
    
}
