package com.stockApp.Application.dao;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    
    String username,email,type,password;
    Integer mobile,confirm;
    public User(){}
    public void equalto(User u){
        this.username = u.username;
        this.email = u.email;
        this.type = u.type;
        this.mobile = u.mobile;
        this.password = u.password;
        
    }
   
    

    
}
