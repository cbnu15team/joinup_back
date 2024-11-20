package com.example.joinup3.repository;

import com.example.joinup3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // ID로 User를 조회하는 메서드
    User findById(String id);
}
