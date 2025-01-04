package com.convention.hall.booking.controller;

import com.convention.hall.booking.model.Hall;
import com.convention.hall.booking.service.HallService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/halls")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class HallController {

    @Autowired
    private HallService hallService;

   
    @PostMapping
    public ResponseEntity<Hall> createHall(@Valid @RequestBody Hall hall) {
        Hall savedHall = hallService.createHall(hall);
        return new ResponseEntity<>(savedHall, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hall>> getAllHalls() {
        return new ResponseEntity<>(hallService.getAllHalls(), HttpStatus.OK);
    }

    @GetMapping("/location/{city}")
    public ResponseEntity<List<Hall>> getHallsByLocation(@PathVariable String city) {
        List<Hall> halls = hallService.getHallsByLocation(city);
        if (halls.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(halls, HttpStatus.OK);
    }
    
    // Get hall by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHallById(@PathVariable Long id) {
        return hallService.getHallById(id)
                .map(hall -> new ResponseEntity<>(hall, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteHall(@PathVariable Long id) {

        hallService.deleteHall(id);

        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Record deleted successfully");
        response.put("id", id);

        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Hall> updateHall(@PathVariable Long id, @Valid @RequestBody Hall hall) {
        
        Hall updatedHall = hallService.updateHall(id, hall);
        if (updatedHall == null) {
           
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedHall, HttpStatus.OK);
    }

}
