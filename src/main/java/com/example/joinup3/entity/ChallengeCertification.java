package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Challenge_certification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeCertification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long challengePostId;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 300)
    private String content;

    @Column(nullable = false, length = 50)
    private String challengeType;

    @Column(length = 2083)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private int likes = 0;
}
