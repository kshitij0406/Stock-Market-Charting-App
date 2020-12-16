package com.stockApp.Application.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    Integer id;
    
    String username, email, type, password;
    Integer mobile;
}
