package com.example.joinup3.controller;

import com.example.joinup3.entity.ChallengePost;
import com.example.joinup3.service.ChallengePostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenge-posts")
public class ChallengePostController {

    private final ChallengePostService challengePostService;

    public ChallengePostController(ChallengePostService challengePostService) {
        this.challengePostService = challengePostService;
    }

    // 모든 인증글 조회
    @GetMapping
    public List<ChallengePost> getAllPosts() {
        return challengePostService.getAllPosts();
    }

    // 특정 게시판의 인증글 조회
    @GetMapping("/board/{boardId}")
    public List<ChallengePost> getPostsByBoardId(@PathVariable Integer boardId) {
        return challengePostService.getPostsByBoardId(boardId);
    }

    // 특정 작성자의 인증글 조회
    @GetMapping("/author/{authorId}")
    public List<ChallengePost> getPostsByAuthorId(@PathVariable Integer authorId) {
        return challengePostService.getPostsByAuthorId(authorId);
    }

    // 인증글 생성
    @PostMapping
    public ChallengePost createPost(@RequestBody ChallengePost challengePost) {
        return challengePostService.createPost(challengePost);
    }

    // 인증글 수정
    @PutMapping("/{postId}")
    public ChallengePost updatePost(@PathVariable Integer postId, @RequestBody ChallengePost updatedPost) {
        return challengePostService.updatePost(postId, updatedPost);
    }

    // 인증글 삭제
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Integer postId) {
        challengePostService.deletePost(postId);
        return "Post deleted successfully";
    }
}
