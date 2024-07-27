package com.example.cogosharing.dto.membership;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberShipRequestDto {
    private Long userId;
    private Long coupleId;
    private Long groupId;
}