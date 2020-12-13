package com.stockApp.Application.controller;

import com.stockApp.Application.exception.ResourceNotFoundException;
import com.stockApp.Application.service.UserService;
import com.stockApp.Application.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/app")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;
    
    
    @GetMapping("/users/all")
    public Iterable<User> getAllUser(){
        
        return userService.getAllUser();
    }
    
    
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        
        return userService.getUserById(id);
    }
    
    @GetMapping("/users/username/{username}")
    public User getUserByUsername(@PathVariable String username){
        
        return userService.getUserByUsername(username);
    }
    
    
    @PostMapping(value = "/users/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    
  
    @PutMapping(value = "/users/update/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id) {
        userService.updateUser(user, id);
    }
    
    @DeleteMapping(value = "/users/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    
}
