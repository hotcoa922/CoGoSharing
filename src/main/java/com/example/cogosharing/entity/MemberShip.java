package com.example.cogosharing.entity;


import com.example.cogosharing.enums.MemberType;
import com.example.cogosharing.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "member_ship")
public class MemberShip extends BaseTimeEntity {
    //맴버 타입에 대한 정보를 가짐


    @Id
    @Column(name = "couple_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type", nullable = false)
    private MemberType memberType;

    @Column(name = "member_id", nullable = false)
    private Long memberId;




    //User - Membership = 1:N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}


//Membership {
//    BIGINT membership_id PK "멤버십 고유 ID"
//    ENUM member_type "멤버 타입 (커플 또는 그룹)"
//    BIGINT member_id "멤버의 ID (커플 또는 그룹 ID)"
//    BIGINT user_id FK "사용자 ID"
//    TIMESTAMP joined_at "멤버십 생성 시각"
//}