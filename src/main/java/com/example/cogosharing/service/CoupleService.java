package com.example.cogosharing.service;


import com.example.cogosharing.dto.membership.RegisterCoupleRequestDto;
import com.example.cogosharing.entity.Couple;
import com.example.cogosharing.repository.CoupleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoupleService {

    private final CoupleRepository coupleRepository;

    @Autowired
    public CoupleService(CoupleRepository coupleRepository) {
        this.coupleRepository = coupleRepository;
    }

    public void registerCouple(RegisterCoupleRequestDto registerCoupleRequestDto) {
        Couple couple = Couple.builder()
                .coupleName(registerCoupleRequestDto.getCoupleName())
                .build();
    }

}
