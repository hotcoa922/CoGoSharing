package com.example.cogosharing.entity;


import com.example.cogosharing.util.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "event")
public class Event extends BaseTimeEntity {

    @Id
    @Column(name = "event_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    // Event - Participant = 1:N
    @OneToMany(mappedBy = "event")
    private List<Participant> participants = new ArrayList<>();

}
