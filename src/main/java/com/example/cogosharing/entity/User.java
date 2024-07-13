package com.example.cogosharing.entity;

import com.example.cogosharing.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = true, nullable = false)
    private String password;


    //User - Membership = 1:N
    @OneToMany( mappedBy = "user")
    private List<MemberShip> memberShips = new ArrayList<>();
}



