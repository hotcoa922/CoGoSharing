package com.example.cogosharing.entity;


import com.example.cogosharing.enums.MemberShipType;
import com.example.cogosharing.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "member_ship")
public class MemberShip extends BaseTimeEntity {

    // Membership 엔티티는 User <-> (Couple, Group)과의 관계를 관리하는 중간 테이블 역할
    // user1은 couple 1개, group 2개를 가지게 될경우 총 3개의 membership을 가지게됨
    // group1은 user1, user2, user3을 소속시키게 할 경우

    @Id
    @Column(name = "member_ship_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "member_ship_type", nullable = false)
    private MemberShipType memberShipType;

    // User - Membership = 1:N
    //모든 membership은 특정 user_id를 가져야만함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Couple - Membership = 1:N
    //커플에 속하지 않을 수 있음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couple_id", nullable = true)
    private Couple couple;

    // Group - Membership = 1:N
    //그룹에 속하지 않을 수 있음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;

}


