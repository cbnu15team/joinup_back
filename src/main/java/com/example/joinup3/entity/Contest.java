package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Contest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contestId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dDay;

    @Column(nullable = false)
    private int views = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Category {
        MARKETING("마케팅"),
        IT("IT"),
        DESIGN("디자인"),
        OTHER("기타");

        private final String description;

        Category(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
