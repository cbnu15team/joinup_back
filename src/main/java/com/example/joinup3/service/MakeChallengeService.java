package com.example.joinup3.service;

import com.example.joinup3.entity.MakeChallenge;
import com.example.joinup3.repository.MakeChallengeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeChallengeService {

    private final MakeChallengeRepository makeChallengeRepository;

    public MakeChallengeService(MakeChallengeRepository makeChallengeRepository) {
        this.makeChallengeRepository = makeChallengeRepository;
    }

    // 모든 챌린지 조회
    public List<MakeChallenge> getAllChallenges() {
        return makeChallengeRepository.findAll();
    }

    // 특정 챌린지 조회
    public MakeChallenge getChallengeById(Integer challengeId) {
        return makeChallengeRepository.findById(challengeId)
                .orElseThrow(() -> new RuntimeException("Challenge not found with id: " + challengeId));
    }

    // 챌린지 생성
    public MakeChallenge createChallenge(MakeChallenge makeChallenge) {
        return makeChallengeRepository.save(makeChallenge);
    }

    // 챌린지 수정
    public MakeChallenge updateChallenge(Integer challengeId, MakeChallenge updatedChallenge) {
        MakeChallenge existingChallenge = getChallengeById(challengeId);
        existingChallenge.setTitle(updatedChallenge.getTitle());
        existingChallenge.setDescription(updatedChallenge.getDescription());
        existingChallenge.setStartDate(updatedChallenge.getStartDate());
        existingChallenge.setEndDate(updatedChallenge.getEndDate());
        existingChallenge.setFrequency(updatedChallenge.getFrequency());
        existingChallenge.setMaxFrequency(updatedChallenge.getMaxFrequency());
        existingChallenge.setBackgroundColor(updatedChallenge.getBackgroundColor());
        existingChallenge.setIcon(updatedChallenge.getIcon());
        existingChallenge.setParticipation(updatedChallenge.getParticipation());
        existingChallenge.setProofBoard(updatedChallenge.getProofBoard());
        return makeChallengeRepository.save(existingChallenge);
    }

    // 챌린지 삭제
    public void deleteChallenge(Integer challengeId) {
        MakeChallenge challenge = getChallengeById(challengeId);
        makeChallengeRepository.delete(challenge);
    }
}
