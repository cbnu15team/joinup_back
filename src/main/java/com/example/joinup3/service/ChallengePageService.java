package com.example.joinup3.service;

import com.example.joinup3.entity.ChallengePage;
import com.example.joinup3.repository.ChallengePageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengePageService {

    private final ChallengePageRepository challengePageRepository;

    public ChallengePageService(ChallengePageRepository challengePageRepository) {
        this.challengePageRepository = challengePageRepository;
    }

    // 모든 페이지 조회
    public List<ChallengePage> getAllPages() {
        return challengePageRepository.findAll();
    }

    // 특정 페이지 조회
    public ChallengePage getPageById(Integer pageId) {
        return challengePageRepository.findById(pageId)
                .orElseThrow(() -> new RuntimeException("Page not found with id: " + pageId));
    }

    // 페이지 생성
    public ChallengePage createPage(ChallengePage challengePage) {
        return challengePageRepository.save(challengePage);
    }

    // 페이지 삭제
    public void deletePage(Integer pageId) {
        ChallengePage page = getPageById(pageId); // 존재 여부 확인
        challengePageRepository.delete(page);
    }
}
