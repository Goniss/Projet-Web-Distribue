package com.example.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import javassist.tools.web.BadHttpRequest;

//import java.util.ArrayList;
import java.util.List;
//import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestWebService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    TablesRepository tablesRepository;
    
    @GetMapping(path = "/")
    public String Hello(){
        return "Bienvenue à notre application";
    }
    
   @GetMapping(path = "/restaurants")
    public Iterable<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
    
    @GetMapping(path = "/restaurants/{name}")
    public Restaurant find(@PathVariable("name") String name) {
        return restaurantRepository.findByName(name);
    }
    
    @DeleteMapping(path = "/restaurants/{name}")
    public void delete(@PathVariable("name") String name) {
         restaurantRepository.delete(restaurantRepository.findByName(name));
    }

    @PostMapping(consumes = "application/json")
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
	
    @PutMapping(path = "/restaurants/{id}",consumes = "application/json")
    public Restaurant update(@PathVariable("id") long id, @RequestBody Restaurant restaurant, String name) throws BadHttpRequest {
        int id2 = (int) id;
    	if (restaurantRepository.findById(id2) != null) {
            restaurant.setName(name);
            return restaurantRepository.save(restaurant);
        } else {
            throw new BadHttpRequest();
        }
    }
    
/*    @GetMapping(path = "/{name}/tables")
    public List<Table> getTables(@PathVariable("name") String name)
    {
    	 return restaurantRepository.findByName(name).getTables();
    	
    }*/
    
}