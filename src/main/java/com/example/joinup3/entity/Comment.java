package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Comments") // 테이블 이름
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "comment_id") // PRIMARY KEY
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // Foreign Key to Users
    private User user;

    @Column(nullable = false, length = 100) // 댓글 내용
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false) // 생성 날짜
    private LocalDate createdAt;
}
