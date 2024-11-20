package com.example.joinup3.repository;

import com.example.joinup3.entity.ChallengeCertification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeCertificationRepository extends JpaRepository<ChallengeCertification, Long> {

    // Find certifications by User ID
    List<ChallengeCertification> findByUserUserId(Long userId);

    // Find certifications by Challenge Type
    List<ChallengeCertification> findByChallengeType(String challengeType);
}
