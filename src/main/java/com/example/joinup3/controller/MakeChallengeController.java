package com.example.joinup3.controller;

import com.example.joinup3.entity.MakeChallenge;
import com.example.joinup3.service.MakeChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/make-challenges")
public class MakeChallengeController {

    private final MakeChallengeService makeChallengeService;

    @Autowired
    public MakeChallengeController(MakeChallengeService makeChallengeService) {
        this.makeChallengeService = makeChallengeService;
    }

    // Create a new challenge
    @PostMapping
    public ResponseEntity<MakeChallenge> createChallenge(@RequestBody MakeChallenge makeChallenge) {
        return ResponseEntity.ok(makeChallengeService.createChallenge(makeChallenge));
    }

    // Get all challenges
    @GetMapping
    public ResponseEntity<List<MakeChallenge>> getAllChallenges() {
        return ResponseEntity.ok(makeChallengeService.getAllChallenges());
    }

    // Get a challenge by ID
    @GetMapping("/{id}")
    public ResponseEntity<MakeChallenge> getChallengeById(@PathVariable Long id) {
        return ResponseEntity.ok(makeChallengeService.getChallengeById(id));
    }

    // Update a challenge
    @PutMapping("/{id}")
    public ResponseEntity<MakeChallenge> updateChallenge(
            @PathVariable Long id,
            @RequestBody MakeChallenge updatedChallenge
    ) {
        return ResponseEntity.ok(makeChallengeService.updateChallenge(id, updatedChallenge));
    }

    // Delete a challenge
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable Long id) {
        makeChallengeService.deleteChallenge(id);
        return ResponseEntity.noContent().build();
    }
}
