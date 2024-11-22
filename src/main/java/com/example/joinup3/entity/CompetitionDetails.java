package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "competitiondetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment 설정
    @Column(name = "details_id")
    private Integer detailsId; // 상세글 고유 ID

    @ManyToOne(fetch = FetchType.LAZY) // CompetitionPage와 다대일 관계
    @JoinColumn(name = "competition_id", nullable = false)
    private CompetitionPage competitionPage; // 공모전 페이지와 연결된 공모전 ID

    @Column(name = "title", nullable = false, length = 100)
    private String title; // 상세글 제목

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content; // 상세글 본문

    @Column(name = "image_url", length = 255)
    private String imageUrl; // 공모전 이미지 URL

    @Column(name = "participation", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean participation; // 참여 여부

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // 상세글 등록 날짜
}
