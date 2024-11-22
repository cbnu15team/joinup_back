package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ChallengePage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChallengePage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name = "page_id")
    private Integer pageId; // 페이지 고유 ID

    @Column(name = "page_name", nullable = false, length = 50)
    private String pageName; // 페이지 이름
}
