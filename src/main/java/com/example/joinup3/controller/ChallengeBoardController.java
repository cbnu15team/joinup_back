package com.example.joinup3.controller;

import com.example.joinup3.entity.ChallengeBoard;
import com.example.joinup3.service.ChallengeBoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge-boards")
public class ChallengeBoardController {

    private final ChallengeBoardService challengeBoardService;

    public ChallengeBoardController(ChallengeBoardService challengeBoardService) {
        this.challengeBoardService = challengeBoardService;
    }

    // 모든 게시판 조회
    @GetMapping
    public List<ChallengeBoard> getAllBoards() {
        return challengeBoardService.getAllBoards();
    }

    // 특정 게시판 조회
    @GetMapping("/{boardId}")
    public ChallengeBoard getBoardById(@PathVariable Integer boardId) {
        return challengeBoardService.getBoardById(boardId);
    }

    // 게시판 생성
    @PostMapping
    public ChallengeBoard createBoard(@RequestBody ChallengeBoard challengeBoard) {
        return challengeBoardService.createBoard(challengeBoard);
    }

    // 게시판 삭제
    @DeleteMapping("/{boardId}")
    public String deleteBoard(@PathVariable Integer boardId) {
        challengeBoardService.deleteBoard(boardId);
        return "Board deleted successfully";
    }
}
