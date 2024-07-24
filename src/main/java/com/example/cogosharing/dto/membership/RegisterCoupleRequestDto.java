package com.example.cogosharing.dto.membership;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterCoupleRequestDto {
    private String coupleName;
}
