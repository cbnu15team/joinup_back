package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Make_Challenge")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MakeChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long challengeId;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 300)
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private int dailyCount;

    @Column(nullable = false)
    private int totalDays;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
