package com.example.cogosharing.repository;

import com.example.cogosharing.entity.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoupleRepository extends JpaRepository<Couple, Long> {
}
