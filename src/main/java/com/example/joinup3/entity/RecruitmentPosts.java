package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recruitmentposts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment 설정
    @Column(name = "post_id")
    private Integer postId; // 모집글 고유 ID

    @ManyToOne(fetch = FetchType.LAZY) // Users와 다대일 관계
    @JoinColumn(name = "author_id", nullable = false)
    private User author; // 작성자 ID (Users 테이블 참조)

    @ManyToOne(fetch = FetchType.LAZY) // CompetitionDetails와 다대일 관계
    @JoinColumn(name = "details_id", nullable = false)
    private CompetitionDetails competitionDetails; // 공모전 상세글 ID와 연관

    @Column(name = "title", nullable = false, length = 20)
    private String title; // 모집글 제목

    @Column(name = "content", nullable = false, length = 300)
    private String content; // 모집글 본문

    @Column(name = "google_form_url", nullable = false, length = 2083)
    private String googleFormUrl; // 구글폼 URL

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // 글 등록 날짜 및 시간
}
