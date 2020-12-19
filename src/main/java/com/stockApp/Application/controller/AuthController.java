package com.stockApp.Application.controller;


import com.stockApp.Application.dao.AuthenticationResponse;
import com.stockApp.Application.dao.LoginRequest;
import com.stockApp.Application.dao.RegisterRequest;
import com.stockApp.Application.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    AuthService authService;
    
    
    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity<String>("User Registration Successfull",
                HttpStatus.OK);
    }
    
    @GetMapping(value = "accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<String>("Account activated Successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
        
    }
    
}
