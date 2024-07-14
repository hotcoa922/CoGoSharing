package com.example.cogosharing.entity;


import com.example.cogosharing.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "participants")
public class Participant extends BaseTimeEntity {

    // Participant 엔티티는 사용자(User) <-> (Event) 간의 관계를 관리하는 중간테이블

    @Id
    @Column(name = "participant_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "membership_type", nullable = false)
    private String membershipType; // "USER", "COUPLE", "GROUP"


    //User - participant = 1:N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    //event - participant = 1:N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;


}