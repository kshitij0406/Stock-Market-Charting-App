package com.stockApp.Application.service;

import com.stockApp.Application.dao.User;
import com.stockApp.Application.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }
    
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
    
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public void addUser(User user) {
        userRepository.save(user);
    }
    
    
    public void updateUser(User user, Integer id) {
        User temp = getUserById(id).orElse(null);
        temp.equalto(user);
        userRepository.save(temp);
    }
    
    public void deleteUser(Integer id) { userRepository.deleteById(id);
    }

}
