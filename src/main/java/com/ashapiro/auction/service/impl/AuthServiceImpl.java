package com.ashapiro.auction.service.impl;

import com.ashapiro.auction.dto.jwt.JwtRequestDto;
import com.ashapiro.auction.dto.jwt.JwtResponseDto;
import com.ashapiro.auction.exceptions.ErrorResponse;
import com.ashapiro.auction.jwt.JwtTokenUtils;
import com.ashapiro.auction.service.AuthService;
import com.ashapiro.auction.userDetails.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public ResponseEntity<?> createAuthToken(JwtRequestDto request) {
        try {
            System.out.println(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.email(), request.password()
                    ));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtTokenUtils.generateToken((UserDetailsImpl) userDetails);
            return ResponseEntity.ok(new JwtResponseDto(token));
        } catch (BadCredentialsException e) {
            return new ResponseEntity(new ErrorResponse(
                    HttpStatus.UNAUTHORIZED.value(),
                    "Invalid email/password"), HttpStatus.UNAUTHORIZED);
        }
    }
}
