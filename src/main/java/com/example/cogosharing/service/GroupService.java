package com.example.cogosharing.service;

import com.example.cogosharing.dto.membership.MemberShipRequestDto;
import com.example.cogosharing.dto.membership.RegisterGroupRequestDto;
import com.example.cogosharing.entity.Group;
import com.example.cogosharing.entity.MemberShip;
import com.example.cogosharing.entity.User;
import com.example.cogosharing.enums.MemberShipType;
import com.example.cogosharing.repository.GroupRepository;
import com.example.cogosharing.repository.MemberShipRepository;
import com.example.cogosharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final MemberShipRepository memberShipRepository;
    

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository, MemberShipRepository memberShipRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.memberShipRepository = memberShipRepository;
    }


    //그룹 생성
    @Transactional
    public Group createGroup(RegisterGroupRequestDto registerGroupRequestDto) {
        Group group = Group.builder()
                .groupName(registerGroupRequestDto.getGroupName())
                .build();
        return groupRepository.save(group);
    }

    //그룹에 가입
    @Transactional
    public MemberShip joinGroup(MemberShipRequestDto memberShipRequestDto) {
        User user = userRepository.findById(memberShipRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자 없음"));
        Group group = groupRepository.findById(memberShipRequestDto.getGroupId())
                .orElseThrow(() -> new RuntimeException("그룹 없음"));

        MemberShip memberShip = MemberShip.builder()
                .user(user)
                .group(group)
                .memberShipType(MemberShipType.Gop)
                .build();
        return memberShipRepository.save(memberShip);
    }

}
