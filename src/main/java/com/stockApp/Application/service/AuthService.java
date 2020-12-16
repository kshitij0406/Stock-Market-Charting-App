package com.stockApp.Application.service;


import com.stockApp.Application.dao.*;
import com.stockApp.Application.exception.SpringRedditException;
import com.stockApp.Application.repository.UserRepository;
import com.stockApp.Application.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;


@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    VerificationTokenRepository verificationTokenRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    MailService mailService;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setType(registerRequest.getType());
        user.setMobile(registerRequest.getMobile());
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setConfirm(false);
        
        userRepository.save(user);
        String token = generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("please Activate Your Account",
                user.getEmail(), "Thank You for Signing Up. Click on below link to activate your account." +
                "http://localhost:8080/auth/accountVerification/" + token));
    }
    
    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        
        verificationTokenRepository.save(verificationToken);
        return token;
    }
    
    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new SpringRedditException("Invallid Token"));
        fetchUserAndEnable(verificationToken.get());
    }
    
    @Transactional
    private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(() -> new SpringRedditException("User Not Found with username" + username));
        user.setConfirm(true);
        userRepository.save(user);
    }
    
    public void login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
    }
}
