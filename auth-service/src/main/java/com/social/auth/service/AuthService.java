package com.social.auth.service;

import org.springframework.stereotype.Service;
import com.social.auth.model.AuthRequest;

@Service
public class AuthService {

    // In-memory check for demo purposes
    public boolean authenticate(AuthRequest request) {
        // For now, accept any login with email containing '@'
        return request.getEmail() != null && request.getEmail().contains("@");
    }
}
