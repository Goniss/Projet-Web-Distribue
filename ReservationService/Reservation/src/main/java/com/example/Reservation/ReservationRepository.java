package com.example.Reservation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
	
	public List<Reservation> findByRestaurant(String restaurant);
	
	public List<Reservation> findByName(String name);
	
	
}
