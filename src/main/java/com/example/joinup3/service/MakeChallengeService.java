package com.example.joinup3.service;

import com.example.joinup3.entity.MakeChallenge;
import com.example.joinup3.repository.MakeChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeChallengeService {

    private final MakeChallengeRepository makeChallengeRepository;

    @Autowired
    public MakeChallengeService(MakeChallengeRepository makeChallengeRepository) {
        this.makeChallengeRepository = makeChallengeRepository;
    }

    // Create a new challenge
    public MakeChallenge createChallenge(MakeChallenge makeChallenge) {
        return makeChallengeRepository.save(makeChallenge);
    }

    // Get all challenges
    public List<MakeChallenge> getAllChallenges() {
        return makeChallengeRepository.findAll();
    }

    // Get a challenge by ID
    public MakeChallenge getChallengeById(Long challengeId) {
        return makeChallengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found with ID: " + challengeId));
    }

    // Update a challenge
    public MakeChallenge updateChallenge(Long challengeId, MakeChallenge updatedChallenge) {
        MakeChallenge existingChallenge = getChallengeById(challengeId);
        existingChallenge.setTitle(updatedChallenge.getTitle());
        existingChallenge.setDescription(updatedChallenge.getDescription());
        existingChallenge.setStartDate(updatedChallenge.getStartDate());
        existingChallenge.setEndDate(updatedChallenge.getEndDate());
        existingChallenge.setDailyCount(updatedChallenge.getDailyCount());
        existingChallenge.setTotalDays(updatedChallenge.getTotalDays());
        return makeChallengeRepository.save(existingChallenge);
    }

    // Delete a challenge
    public void deleteChallenge(Long challengeId) {
        makeChallengeRepository.deleteById(challengeId);
    }
}
