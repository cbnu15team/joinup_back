package com.example.joinup3.repository;

import com.example.joinup3.entity.MakeChallenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeChallengeRepository extends JpaRepository<MakeChallenge, Integer> {
    // 기본 CRUD 메서드 제공
}
