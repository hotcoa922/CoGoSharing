package com.example.cogosharing.service;

import com.example.cogosharing.dto.user.LoginRequestDto;
import com.example.cogosharing.dto.user.RegisterRequestDto;
import com.example.cogosharing.entity.User;
import com.example.cogosharing.jwt.JwtTokenProvider;
import com.example.cogosharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    public void registerUser(RegisterRequestDto registerRequestDto) {
        User user = User.builder()
                .userName(registerRequestDto.getUserName())
                .email(registerRequestDto.getEmail())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .build();

        userRepository.save(user);
    }

    public String loginUser(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail());
        if (user == null) {
            throw new UsernameNotFoundException(loginRequestDto.getEmail());
        }


        if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return jwtTokenProvider.createToken(user.getEmail(), user.getUserName());
    }
}
