package com.example.cogosharing.service;


import com.example.cogosharing.dto.membership.MemberShipRequestDto;
import com.example.cogosharing.dto.membership.RegisterCoupleRequestDto;
import com.example.cogosharing.entity.Couple;
import com.example.cogosharing.entity.MemberShip;
import com.example.cogosharing.entity.User;
import com.example.cogosharing.enums.MemberShipType;
import com.example.cogosharing.repository.CoupleRepository;
import com.example.cogosharing.repository.MemberShipRepository;
import com.example.cogosharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoupleService {

    private final UserRepository userRepository;
    private final CoupleRepository coupleRepository;
    private final MemberShipRepository memberShipRepository;

    @Autowired
    public CoupleService(CoupleRepository coupleRepository, UserRepository userRepository, MemberShipRepository memberShipRepository ) {
        this.coupleRepository = coupleRepository;
        this.userRepository = userRepository;
        this.memberShipRepository = memberShipRepository;
    }

    // 커플 생성
    @Transactional
    public Couple createCouple(RegisterCoupleRequestDto registerCoupleRequestDto) {
        Couple couple = Couple.builder()
                .coupleName(registerCoupleRequestDto.getCoupleName())
                .build();
        return coupleRepository.save(couple);
    }

    // 커플에 가입
    @Transactional
    public MemberShip joinCouple(MemberShipRequestDto memberShipRequestDto) {
        User user = userRepository.findById(memberShipRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        Couple couple = coupleRepository.findById(memberShipRequestDto.getCoupleId())
                .orElseThrow(() -> new RuntimeException("커플 없음"));

        MemberShip memberShip = MemberShip.builder()
                .user(user)
                .couple(couple)
                .memberShipType(MemberShipType.Cop)
                .build();
        return memberShipRepository.save(memberShip);
    }

    // 커플 탈퇴
    @Transactional
    public void leaveCouple(MemberShipRequestDto memberShipRequestDto) {
        User user = userRepository.findById(memberShipRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        Couple couple = coupleRepository.findById(memberShipRequestDto.getCoupleId())
                .orElseThrow(() -> new RuntimeException("커플 없음"));

        memberShipRepository.deleteByUserAndCouple(user, couple);
    }

}
