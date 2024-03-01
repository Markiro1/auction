package com.ashapiro.auction.controller;

import com.ashapiro.auction.dto.registration.RegisterUserDto;
import com.ashapiro.auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RegisterUserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }
}
