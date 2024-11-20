package com.example.joinup3.controller;

import com.example.joinup3.entity.ChallengeCertification;
import com.example.joinup3.service.ChallengeCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge-certifications")
public class ChallengeCertificationController {

    private final ChallengeCertificationService challengeCertificationService;

    @Autowired
    public ChallengeCertificationController(ChallengeCertificationService challengeCertificationService) {
        this.challengeCertificationService = challengeCertificationService;
    }

    // Create a new challenge certification
    @PostMapping
    public ResponseEntity<ChallengeCertification> createCertification(
            @RequestBody ChallengeCertification certification) {
        return ResponseEntity.ok(challengeCertificationService.createChallengeCertification(certification));
    }

    // Get all challenge certifications
    @GetMapping
    public ResponseEntity<List<ChallengeCertification>> getAllCertifications() {
        return ResponseEntity.ok(challengeCertificationService.getAllChallengeCertifications());
    }

    // Get certifications by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChallengeCertification>> getCertificationsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(challengeCertificationService.getCertificationsByUserId(userId));
    }

    // Get certifications by Challenge Type
    @GetMapping("/type/{challengeType}")
    public ResponseEntity<List<ChallengeCertification>> getCertificationsByChallengeType(
            @PathVariable String challengeType) {
        return ResponseEntity.ok(challengeCertificationService.getCertificationsByChallengeType(challengeType));
    }

    // Get a single certification by ID
    @GetMapping("/{id}")
    public ResponseEntity<ChallengeCertification> getCertificationById(@PathVariable Long id) {
        return ResponseEntity.ok(challengeCertificationService.getCertificationById(id));
    }

    // Delete a certification by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertification(@PathVariable Long id) {
        challengeCertificationService.deleteCertification(id);
        return ResponseEntity.noContent().build();
    }
}
