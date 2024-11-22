package com.example.joinup3.repository;

import com.example.joinup3.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 사용자(user_id)의 모든 댓글 조회
    List<Comment> findByUserUserId(Integer userId);
}
