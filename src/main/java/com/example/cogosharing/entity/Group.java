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
@Table(name = "group")
public class Group extends BaseTimeEntity {


    @Id
    @Column(name = "group_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    //Group - MemberShip = 1 : N
    @OneToMany(mappedBy = "group")
    private List<MemberShip> memberShips = new ArrayList<>();
}
