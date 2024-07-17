package com.example.cogosharing.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor //이걸 왜 써줘야하는지 공부가 필요하다
public class LoginResponseDto {
    private String token;
}
