package com.example.cogosharing.dto.user;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RegisterRequestDto {
    private String userName;
    private String email;
    private String password;
}
