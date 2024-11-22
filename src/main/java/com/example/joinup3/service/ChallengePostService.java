package com.example.joinup3.service;

import com.example.joinup3.entity.ChallengePost;
import com.example.joinup3.repository.ChallengePostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengePostService {

    private final ChallengePostRepository challengePostRepository;

    public ChallengePostService(ChallengePostRepository challengePostRepository) {
        this.challengePostRepository = challengePostRepository;
    }

    // 모든 인증글 조회
    public List<ChallengePost> getAllPosts() {
        return challengePostRepository.findAll();
    }

    // 특정 게시판의 인증글 조회
    public List<ChallengePost> getPostsByBoardId(Integer boardId) {
        return challengePostRepository.findByChallengeBoardBoardId(boardId);
    }

    // 특정 작성자의 인증글 조회
    public List<ChallengePost> getPostsByAuthorId(Integer authorId) {
        return challengePostRepository.findByAuthorUserId(authorId);
    }

    // 인증글 생성
    public ChallengePost createPost(ChallengePost challengePost) {
        return challengePostRepository.save(challengePost);
    }

    // 인증글 수정
    public ChallengePost updatePost(Integer postId, ChallengePost updatedPost) {
        ChallengePost existingPost = challengePostRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setImageUrl(updatedPost.getImageUrl());
        existingPost.setLikes(updatedPost.getLikes());
        return challengePostRepository.save(existingPost);
    }

    // 인증글 삭제
    public void deletePost(Integer postId) {
        ChallengePost post = challengePostRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        challengePostRepository.delete(post);
    }
}
