package com.stockApp.Application.model;

import com.stockApp.Application.dao.RegisterRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    String username, email, type, password;
    Integer mobile;
    boolean confirm;


    public void equalto(User u) {
        this.username = u.username;
        this.email = u.email;
        this.type = u.type;
        this.mobile = u.mobile;
        this.password = u.password;
        
    }
    
    public void mapToRegisterRequest(RegisterRequest registerRequest) {
        this.type = registerRequest.getType();
        this.mobile = registerRequest.getMobile();
        this.email = registerRequest.getEmail();
        this.username = registerRequest.getUsername();
        this.password = registerRequest.getPassword();
        this.confirm = false;
    }
    
    
}
