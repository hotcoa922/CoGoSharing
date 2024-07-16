package com.example.cogosharing.service;

import com.example.cogosharing.dto.user.RegisterRequestDto;
import com.example.cogosharing.entity.User;
import com.example.cogosharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(RegisterRequestDto registerRequestDto) {
        User user = User.builder()
                .userName(registerRequestDto.getUserName())
                .email(registerRequestDto.getEmail())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .build();

        userRepository.save(user);

    }
}
