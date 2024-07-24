package com.example.cogosharing.dto.membership;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterGroupRequestDto {
    private String groupName;
}
