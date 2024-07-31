package com.example.cogosharing.repository;

import com.example.cogosharing.entity.Couple;
import com.example.cogosharing.entity.Group;
import com.example.cogosharing.entity.MemberShip;
import com.example.cogosharing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberShipRepository extends JpaRepository<MemberShip, Long> {

    void deleteByUserAndGroup(User user, Group group);

    void deleteByUserAndCouple(User user, Couple couple);
}
