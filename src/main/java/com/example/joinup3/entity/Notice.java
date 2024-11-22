package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Notice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "notice_id")
    private Long noticeId; // 공지글 고유 식별자

    @Column(name = "title", nullable = false, length = 100)
    private String title; // 공지글 제목

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content; // 공지글 내용

    @Column(name = "upload_date", nullable = false)
    private LocalDate uploadDate; // 공지글 업로드 날짜
}
