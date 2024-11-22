package com.example.joinup3.controller;

import com.example.joinup3.entity.Comment;
import com.example.joinup3.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 모든 댓글 조회
    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // 특정 사용자(user_id)의 댓글 조회
    @GetMapping("/user/{userId}")
    public List<Comment> getCommentsByUserId(@PathVariable Integer userId) {
        return commentService.getCommentsByUserId(userId);
    }

    // 댓글 생성
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "Comment deleted successfully";
    }
}
