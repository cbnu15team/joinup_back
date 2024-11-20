package com.example.joinup3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users") // DB의 User 테이블과 매핑
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment 설정
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    @Column(name = "BIRTH", nullable = false, length = 8)
    private String birth;

    @Column(name = "PHONE", nullable = false, unique = true, length = 11)
    private String phone;

    @Column(name = "USERNAME", nullable = false, length = 20)
    private String username;

    @Column(name = "ID", nullable = false, unique = true, length = 20)
    private String id;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}
