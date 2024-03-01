package com.ashapiro.auction.controller;

import com.ashapiro.auction.dto.jwt.JwtRequestDto;
import com.ashapiro.auction.dto.jwt.JwtResponseDto;
import com.ashapiro.auction.exceptions.ErrorResponse;
import com.ashapiro.auction.jwt.JwtTokenUtils;
import com.ashapiro.auction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtils jwtTokenUtils;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequestDto authRequest) {
        try {
            System.out.println(new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password()));
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password()
                    ));
        } catch (AuthenticationException e) {
            System.out.println("ERROR");
            return new ResponseEntity(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
                    "Invalid email or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.email());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }
}
