package com.example.User;

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
@RequestMapping(path = "/users")
public class RestWebService {
	
	@Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }


    @GetMapping(path = "/restaurants/{name}")
    public User find(@PathVariable("name") String name) {
        return userRepository.findByName(name);
    }
    
    @DeleteMapping(path = "/restaurants/{id}")
    public void delete(@PathVariable("id") Integer id) {
         userRepository.deleteById(id);
    }

    @PostMapping(consumes = "application/json")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }
	
    @PutMapping(path = "/{name}")
    public User update(@PathVariable("name") String name, @RequestBody User user) throws BadHttpRequest {
        if (userRepository.findByName(name) != null) {
            user.setName(name);
            return userRepository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }
}
