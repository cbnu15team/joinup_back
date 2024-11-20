package com.example.joinup3.service;

import com.example.joinup3.entity.ChallengeCertification;
import com.example.joinup3.repository.ChallengeCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeCertificationService {

    private final ChallengeCertificationRepository challengeCertificationRepository;

    @Autowired
    public ChallengeCertificationService(ChallengeCertificationRepository challengeCertificationRepository) {
        this.challengeCertificationRepository = challengeCertificationRepository;
    }

    // Create a new challenge certification
    public ChallengeCertification createChallengeCertification(ChallengeCertification certification) {
        return challengeCertificationRepository.save(certification);
    }

    // Get all challenge certifications
    public List<ChallengeCertification> getAllChallengeCertifications() {
        return challengeCertificationRepository.findAll();
    }

    // Get certifications by User ID
    public List<ChallengeCertification> getCertificationsByUserId(Long userId) {
        return challengeCertificationRepository.findByUserUserId(userId);
    }

    // Get certifications by Challenge Type
    public List<ChallengeCertification> getCertificationsByChallengeType(String challengeType) {
        return challengeCertificationRepository.findByChallengeType(challengeType);
    }

    // Get a single certification by ID
    public ChallengeCertification getCertificationById(Long challengePostId) {
        return challengeCertificationRepository.findById(challengePostId)
                .orElseThrow(() -> new RuntimeException("Challenge Certification not found with ID: " + challengePostId));
    }

    // Delete a certification
    public void deleteCertification(Long challengePostId) {
        challengeCertificationRepository.deleteById(challengePostId);
    }
}
