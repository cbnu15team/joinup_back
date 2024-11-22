package com.example.joinup3.controller;

import com.example.joinup3.entity.MakeChallenge;
import com.example.joinup3.service.MakeChallengeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/make-challenges")
public class MakeChallengeController {

    private final MakeChallengeService makeChallengeService;

    public MakeChallengeController(MakeChallengeService makeChallengeService) {
        this.makeChallengeService = makeChallengeService;
    }

    // 모든 챌린지 조회
    @GetMapping
    public List<MakeChallenge> getAllChallenges() {
        return makeChallengeService.getAllChallenges();
    }

    // 특정 챌린지 조회
    @GetMapping("/{challengeId}")
    public MakeChallenge getChallengeById(@PathVariable Integer challengeId) {
        return makeChallengeService.getChallengeById(challengeId);
    }

    // 챌린지 생성
    @PostMapping
    public MakeChallenge createChallenge(@RequestBody MakeChallenge makeChallenge) {
        return makeChallengeService.createChallenge(makeChallenge);
    }

    // 챌린지 수정
    @PutMapping("/{challengeId}")
    public MakeChallenge updateChallenge(@PathVariable Integer challengeId, @RequestBody MakeChallenge updatedChallenge) {
        return makeChallengeService.updateChallenge(challengeId, updatedChallenge);
    }

    // 챌린지 삭제
    @DeleteMapping("/{challengeId}")
    public String deleteChallenge(@PathVariable Integer challengeId) {
        makeChallengeService.deleteChallenge(challengeId);
        return "Challenge deleted successfully";
    }
}
