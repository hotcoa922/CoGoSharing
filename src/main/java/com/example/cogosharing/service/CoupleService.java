package com.example.cogosharing.service;

import com.example.cogosharing.dto.membership.MemberShipRequestDto;
import com.example.cogosharing.dto.membership.RegisterCoupleRequestDto;
import com.example.cogosharing.entity.Couple;
import com.example.cogosharing.entity.MemberShip;

public interface CoupleService {
    Couple createCouple(RegisterCoupleRequestDto registerCoupleRequestDto);
    MemberShip joinCouple(MemberShipRequestDto memberShipRequestDto);
    void leaveCouple(MemberShipRequestDto memberShipRequestDto);
}
