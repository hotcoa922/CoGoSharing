package com.example.cogosharing.entity;


import com.example.cogosharing.util.time.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "couple")
public class Couple extends BaseTimeEntity {

    @Id
    @Column(name = "couple_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "couple_name")
    private String coupleName;

    //Couple - MemberShip = 1 : N
    //사실 커플은 N=2이지만 편의상 1대 다 관계로 생각
    @OneToMany(mappedBy = "couple")
    private List<MemberShip> memberShips = new ArrayList<>();


    @Builder
    public Couple(String coupleName){
        this.coupleName = coupleName;
    }
}
