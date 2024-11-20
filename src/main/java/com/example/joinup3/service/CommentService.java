package com.example.joinup3.service;

import com.example.joinup3.entity.Comment;
import com.example.joinup3.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // Create a new comment
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // Get all comments for a specific post
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostPostId(postId);
    }

    // Get all comments by a specific user
    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserUserId(userId);
    }

    // Get a single comment by ID
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found with ID: " + commentId));
    }

    // Delete a comment
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
