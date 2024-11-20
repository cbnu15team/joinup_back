package com.example.joinup3.repository;

import com.example.joinup3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Find comments by Post ID
    List<Comment> findByPostPostId(Long postId);

    // Find comments by User ID
    List<Comment> findByUserUserId(Long userId);
}
