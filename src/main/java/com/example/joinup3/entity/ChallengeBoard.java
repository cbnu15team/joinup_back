package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "challengeboard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment 설정
    @Column(name = "board_id")
    private Integer boardId; // 게시판 고유 ID

    @Column(name = "category", nullable = false, length = 50)
    private String category; // 챌린지 분류

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // 게시판 생성 시간

    @ManyToOne(fetch = FetchType.LAZY) // ChallengeMake와 다대일 관계 설정
    @JoinColumn(name = "challenge_id", nullable = false)
    private MakeChallenge makeChallenge; // 챌린지 등록 ID와 연관
}
