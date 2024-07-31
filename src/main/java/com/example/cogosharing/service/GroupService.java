package com.example.cogosharing.service;

import com.example.cogosharing.dto.membership.MemberShipRequestDto;
import com.example.cogosharing.dto.membership.RegisterGroupRequestDto;
import com.example.cogosharing.entity.Group;
import com.example.cogosharing.entity.MemberShip;

public interface GroupService {
    Group createGroup(RegisterGroupRequestDto registerGroupRequestDto);
    MemberShip joinGroup(MemberShipRequestDto memberShipRequestDto);
    void leaveGroup(MemberShipRequestDto memberShipRequestDto);

}
