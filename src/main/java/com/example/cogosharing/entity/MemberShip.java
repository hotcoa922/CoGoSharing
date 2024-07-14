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

    @Id
    @Column(name = "member_ship_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_ship_type", nullable = false)
    private MemberShipType memberShipType;

    @Column(name = "member_ship_id", nullable = false)
    private Long memberShipId;  //커플 혹은 그룹 id

    //User - Membership = 1:N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //Couple : MemberShip = 1 : N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couple_id")
    private Couple couple;


    //Couple : MemberShip = 1 : N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

}


