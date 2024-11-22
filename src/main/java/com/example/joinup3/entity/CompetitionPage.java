package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "competitionpage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment 설정
    @Column(name = "competition_id")
    private Integer competitionId; // 공모전 등록 번호

    @Column(name = "title", nullable = false, length = 100)
    private String title; // 공모전 제목

    @Column(name = "deadline", nullable = false)
    private LocalDateTime deadline; // 공모전 마감 기한

    @Column(name = "views", columnDefinition = "INT DEFAULT 0")
    private Integer views; // 조회수

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // 등록 날짜
}
