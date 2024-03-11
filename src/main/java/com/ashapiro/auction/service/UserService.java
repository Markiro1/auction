package com.ashapiro.auction.service;

import com.ashapiro.auction.dto.registration.RegisterUserDto;
import com.ashapiro.auction.dto.registration.UserResponseDto;
import com.ashapiro.auction.entity.User;

import java.util.Optional;

public interface UserService {

    UserResponseDto save(RegisterUserDto userDto);

    Optional<User> findByEmail(String email);
}
