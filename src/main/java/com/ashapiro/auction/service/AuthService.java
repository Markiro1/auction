package com.ashapiro.auction.service;

import com.ashapiro.auction.dto.jwt.JwtRequestDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> createAuthToken(JwtRequestDto request);
}
