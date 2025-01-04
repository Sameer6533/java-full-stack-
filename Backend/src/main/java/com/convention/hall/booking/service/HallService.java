package com.convention.hall.booking.service;

import com.convention.hall.booking.model.Hall;
import com.convention.hall.booking.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

   
    @Transactional
    public Hall createHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    public Optional<Hall> getHallById(Long id) {
        return hallRepository.findById(id);
    }

    @Transactional
    public void deleteHall(Long id) {
        hallRepository.deleteById(id);
    }
    
    public List<Hall> getHallsByLocation(String location) {
        return hallRepository.findByLocationIgnoreCase(location);
    }
    
    public Hall updateHall(Long id, Hall hall) {
      
        return hallRepository.findById(id).map(existingHall -> {
            
            existingHall.setName(hall.getName());
            existingHall.setLocation(hall.getLocation());
            existingHall.setCapacity(hall.getCapacity());
            existingHall.setCost(hall.getCost());
  
            return hallRepository.save(existingHall);
        }).orElse(null); 
    }
}
