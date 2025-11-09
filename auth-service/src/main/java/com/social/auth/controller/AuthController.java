package com.social.auth.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.social.auth.model.AuthRequest;
import com.social.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        boolean success = authService.authenticate(request);
        if (success) {
            return "Login Successful";
        } else {
            return "Invalid Credentials";
        }
    }
}

