package com.stockApp.Application.controller;

import com.stockApp.Application.dao.User;
import com.stockApp.Application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    
    
    @GetMapping("/all")
    public Iterable<User> getAllUser(){
        
        return userService.getAllUser();
    }
    
    
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        
        return userService.getUserById(id);
    }
    
    @GetMapping("/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        
        return userService.getUserByUsername(username);
    }


    @PutMapping(value = "/update/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id) {
        userService.updateUser(user, id);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    
}
