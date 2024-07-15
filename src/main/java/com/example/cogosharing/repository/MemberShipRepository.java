package com.example.cogosharing.repository;

import com.example.cogosharing.entity.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberShipRepository extends JpaRepository<MemberShip, Long> {
}
