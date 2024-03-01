package com.ashapiro.auction.dto.registration;

import lombok.Data;

@Data
public class RegisterUserDto {
        String email;
        String firstName;
        String lastName;
        String password;
}
