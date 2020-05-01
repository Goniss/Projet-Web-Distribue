package com.example.Reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.tools.web.BadHttpRequest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(path = "/reservations")
public class RestWebService {
	
	@Autowired
     ReservationRepository reservationRepository;

    @GetMapping("/")
    public Iterable<Reservation> getreservations(){
        return reservationRepository.findAll();
    }


    @GetMapping(path = "/reservations/restaurants/{name}")
    public List<Reservation> findByRestaurant(@PathVariable("name") String name) {
        return reservationRepository.findByRestaurant(name);
    }
    
    @DeleteMapping(path = "/reservations/{id}")
    public void delete(@PathVariable("id") Integer id) {
         reservationRepository.deleteById(id);
    }

    @PostMapping(consumes = "application/json")
    public Reservation create(@RequestBody Reservation Reservation) {
        return reservationRepository.save(Reservation);
    }
	
    @PutMapping(path = "/{name}")
    public Reservation update(@PathVariable("name") String name, @RequestBody Reservation Reservation) throws BadHttpRequest {
        if (reservationRepository.findByName(name) != null) {
            Reservation.setName(name);
            return reservationRepository.save(Reservation);
        } else {
            throw new BadHttpRequest();
        }
    }

}
