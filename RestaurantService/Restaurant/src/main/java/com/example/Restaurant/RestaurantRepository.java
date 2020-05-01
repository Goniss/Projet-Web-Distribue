package com.example.Restaurant;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository  extends CrudRepository<Restaurant, Integer>{
	
	public Restaurant findByName(String name);

	public void deleteById(long id);

	public boolean existsByName(String name);
}
