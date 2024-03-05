package com.ashapiro.auction.service.impl;

import com.ashapiro.auction.dto.registration.RegisterUserDto;
import com.ashapiro.auction.dto.registration.UserResponseDto;
import com.ashapiro.auction.entity.Role;
import com.ashapiro.auction.entity.User;
import com.ashapiro.auction.exceptions.DuplicateUserException;
import com.ashapiro.auction.repository.UserRepository;
import com.ashapiro.auction.service.RoleService;
import com.ashapiro.auction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    @Transactional
    @Override
    public UserResponseDto save(RegisterUserDto request) {
        validateEmail(request.getEmail());
        User user = createUserFromRequest(request);
        addUserRole(user);
        userRepository.save(user);
        return new UserResponseDto(user.getId(), user.getEmail());
    }

    private void addUserRole(User user) {
        Role role = roleService.findByName("ROLE_USER");
        user.getRoles().add(role);
    }

    private User createUserFromRequest(RegisterUserDto request) {
        User user = convertToUserFromRequest(request);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return user;
    }

    private void validateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateUserException(String.format("User with email: %s already exists", email));
        }
    }

    private User convertToUserFromRequest(RegisterUserDto userRequestDto) {
        return modelMapper.map(userRequestDto, User.class);
    }
}
