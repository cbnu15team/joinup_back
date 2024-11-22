package com.example.joinup3.repository;

import com.example.joinup3.entity.ChallengePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengePostRepository extends JpaRepository<ChallengePost, Integer> {

    // 특정 게시판(board_id)의 모든 인증글 조회
    List<ChallengePost> findByChallengeBoardBoardId(Integer boardId);

    // 특정 작성자(author_id)의 모든 인증글 조회
    List<ChallengePost> findByAuthorUserId(Integer authorId);
}
