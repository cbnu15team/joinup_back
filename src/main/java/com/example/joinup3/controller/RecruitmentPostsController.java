package com.example.joinup3.controller;

import com.example.joinup3.entity.RecruitmentPosts;
import com.example.joinup3.service.RecruitmentPostsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment-posts")
public class RecruitmentPostsController {

    private final RecruitmentPostsService recruitmentPostsService;

    public RecruitmentPostsController(RecruitmentPostsService recruitmentPostsService) {
        this.recruitmentPostsService = recruitmentPostsService;
    }

    // 모든 모집글 조회
    @GetMapping
    public List<RecruitmentPosts> getAllPosts() {
        return recruitmentPostsService.getAllPosts();
    }

    // 특정 작성자의 모집글 조회
    @GetMapping("/author/{authorId}")
    public List<RecruitmentPosts> getPostsByAuthorId(@PathVariable Integer authorId) {
        return recruitmentPostsService.getPostsByAuthorId(authorId);
    }

    // 특정 공모전 상세글의 모집글 조회
    @GetMapping("/details/{detailsId}")
    public List<RecruitmentPosts> getPostsByDetailsId(@PathVariable Integer detailsId) {
        return recruitmentPostsService.getPostsByDetailsId(detailsId);
    }

    // 모집글 생성
    @PostMapping
    public RecruitmentPosts createPost(@RequestBody RecruitmentPosts recruitmentPost) {
        return recruitmentPostsService.createPost(recruitmentPost);
    }

    // 모집글 수정
    @PutMapping("/{postId}")
    public RecruitmentPosts updatePost(@PathVariable Integer postId, @RequestBody RecruitmentPosts updatedPost) {
        return recruitmentPostsService.updatePost(postId, updatedPost);
    }

    // 모집글 삭제
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Integer postId) {
        recruitmentPostsService.deletePost(postId);
        return "Recruitment post deleted successfully";
    }
}
