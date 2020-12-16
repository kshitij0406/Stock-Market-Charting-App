package com.stockApp.Application.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
        this.type = registerRequest.type;
        this.mobile = registerRequest.mobile;
        this.email = registerRequest.email;
        this.username = registerRequest.username;
        this.password = registerRequest.password;
        this.confirm = false;
    }
    
    
}
