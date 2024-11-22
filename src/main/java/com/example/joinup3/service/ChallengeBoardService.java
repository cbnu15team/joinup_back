package com.example.joinup3.service;

import com.example.joinup3.entity.ChallengeBoard;
import com.example.joinup3.repository.ChallengeBoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeBoardService {

    private final ChallengeBoardRepository challengeBoardRepository;

    public ChallengeBoardService(ChallengeBoardRepository challengeBoardRepository) {
        this.challengeBoardRepository = challengeBoardRepository;
    }

    // 모든 게시판 조회
    public List<ChallengeBoard> getAllBoards() {
        return challengeBoardRepository.findAll();
    }

    // 특정 게시판 조회
    public ChallengeBoard getBoardById(Integer boardId) {
        return challengeBoardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + boardId));
    }

    // 게시판 생성
    public ChallengeBoard createBoard(ChallengeBoard challengeBoard) {
        return challengeBoardRepository.save(challengeBoard);
    }

    // 게시판 삭제
    public void deleteBoard(Integer boardId) {
        ChallengeBoard board = getBoardById(boardId); // 존재 여부 확인
        challengeBoardRepository.delete(board);
    }
}
