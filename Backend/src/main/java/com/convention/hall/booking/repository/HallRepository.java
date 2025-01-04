package com.convention.hall.booking.repository;



import com.convention.hall.booking.model.Hall;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    
	
	 List<Hall> findByLocationIgnoreCase(String location);
}
