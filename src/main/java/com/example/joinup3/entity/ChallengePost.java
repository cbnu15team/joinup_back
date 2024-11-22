package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "challengepost")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment 설정
    @Column(name = "post_id")
    private Integer postId; // 인증글 고유 ID

    @Column(name = "title", nullable = false, length = 20)
    private String title; // 인증글 제목

    @Column(name = "content", length = 300)
    private String content; // 인증글 내용

    @Column(name = "image_url", length = 255)
    private String imageUrl; // 첨부된 사진 URL

    @Column(name = "likes", columnDefinition = "INT DEFAULT 0")
    private Integer likes; // 추천(좋아요) 수

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // 생성 시간

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt; // 마지막 수정 시간

    @ManyToOne(fetch = FetchType.LAZY) // ChallengeBoard와 다대일 관계 설정
    @JoinColumn(name = "board_id", nullable = false)
    private ChallengeBoard challengeBoard; // 게시판 ID와 연관

    @ManyToOne(fetch = FetchType.LAZY) // Users 테이블과 다대일 관계 설정
    @JoinColumn(name = "author_id", nullable = false)
    private User author; // 작성자와 연관
}
