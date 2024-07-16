package com.example.cogosharing.dto.user;


import lombok.Data;


@Data
public class RegisterRequestDto {
    private String userName;
    private String email;
    private String password;
}
