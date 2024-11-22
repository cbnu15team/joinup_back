package com.example.joinup3.repository;

import com.example.joinup3.entity.ChallengePage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengePageRepository extends JpaRepository<ChallengePage, Integer> {
    // 기본 CRUD 메서드는 JpaRepository에서 제공됨
}
