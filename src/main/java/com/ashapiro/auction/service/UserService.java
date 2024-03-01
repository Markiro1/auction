package com.ashapiro.auction.service;

import com.ashapiro.auction.dto.registration.RegisterUserDto;
import com.ashapiro.auction.dto.registration.UserResponseDto;

public interface UserService {

    UserResponseDto save(RegisterUserDto userDto);
}
