package com.example.cogosharing.repository;

import com.example.cogosharing.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {


    Optional<Group> findById(Long id);
}
