package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChallengeMake")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MakeChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "challenge_id")
    private Integer challengeId; // 챌린지 고유 ID

    @Column(name = "title", nullable = false, length = 20)
    private String title; // 챌린지 제목

    @Column(name = "description", length = 300)
    private String description; // 챌린지 설명

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate; // 시작 날짜

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate; // 종료 날짜

    @Column(name = "frequency", nullable = false, length = 10)
    private String frequency; // 인증 빈도

    @Column(name = "max_frequency", nullable = false)
    private Integer maxFrequency; // 최대 인증 횟수

    @Column(name = "background_color", length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'white'")
    private String backgroundColor; // 배경색

    @Column(name = "icon", length = 255, columnDefinition = "VARCHAR(255) DEFAULT 'none'")
    private String icon; // 아이콘

    @Column(name = "participation", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean participation; // 참여 여부

    @Column(name = "proof_board", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean proofBoard; // 인증 게시판 이동 가능 여부

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // 생성 시간

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt; // 마지막 수정 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy; // 생성자 (Users 테이블 외래 키)
}
