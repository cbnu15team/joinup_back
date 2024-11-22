package com.example.joinup3.controller;

import com.example.joinup3.entity.ChallengePage;
import com.example.joinup3.service.ChallengePageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge-pages")
public class ChallengePageController {

    private final ChallengePageService challengePageService;

    public ChallengePageController(ChallengePageService challengePageService) {
        this.challengePageService = challengePageService;
    }

    // 모든 페이지 조회
    @GetMapping
    public List<ChallengePage> getAllPages() {
        return challengePageService.getAllPages();
    }

    // 특정 페이지 조회
    @GetMapping("/{pageId}")
    public ChallengePage getPageById(@PathVariable Integer pageId) {
        return challengePageService.getPageById(pageId);
    }

    // 페이지 생성
    @PostMapping
    public ChallengePage createPage(@RequestBody ChallengePage challengePage) {
        return challengePageService.createPage(challengePage);
    }

    // 페이지 삭제
    @DeleteMapping("/{pageId}")
    public String deletePage(@PathVariable Integer pageId) {
        challengePageService.deletePage(pageId);
        return "Page deleted successfully";
    }
}
