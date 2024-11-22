package com.example.joinup3.service;

import com.example.joinup3.entity.RecruitmentPosts;
import com.example.joinup3.repository.RecruitmentPostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentPostsService {

    private final RecruitmentPostsRepository recruitmentPostsRepository;

    public RecruitmentPostsService(RecruitmentPostsRepository recruitmentPostsRepository) {
        this.recruitmentPostsRepository = recruitmentPostsRepository;
    }

    // 모든 모집글 조회
    public List<RecruitmentPosts> getAllPosts() {
        return recruitmentPostsRepository.findAll();
    }

    // 특정 작성자의 모집글 조회
    public List<RecruitmentPosts> getPostsByAuthorId(Integer authorId) {
        return recruitmentPostsRepository.findByAuthorUserId(authorId);
    }

    // 특정 공모전 상세글의 모집글 조회
    public List<RecruitmentPosts> getPostsByDetailsId(Integer detailsId) {
        return recruitmentPostsRepository.findByCompetitionDetailsDetailsId(detailsId);
    }

    // 모집글 생성
    public RecruitmentPosts createPost(RecruitmentPosts recruitmentPost) {
        return recruitmentPostsRepository.save(recruitmentPost);
    }

    // 모집글 수정
    public RecruitmentPosts updatePost(Integer postId, RecruitmentPosts updatedPost) {
        RecruitmentPosts existingPost = recruitmentPostsRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setGoogleFormUrl(updatedPost.getGoogleFormUrl());
        return recruitmentPostsRepository.save(existingPost);
    }

    // 모집글 삭제
    public void deletePost(Integer postId) {
        RecruitmentPosts post = recruitmentPostsRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        recruitmentPostsRepository.delete(post);
    }
}
