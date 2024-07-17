package com.example.cogosharing.dto.user;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
