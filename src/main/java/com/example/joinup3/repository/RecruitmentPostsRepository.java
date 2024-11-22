package com.example.joinup3.repository;

import com.example.joinup3.entity.RecruitmentPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitmentPostsRepository extends JpaRepository<RecruitmentPosts, Integer> {

    // 특정 작성자의 모집글 조회
    List<RecruitmentPosts> findByAuthorUserId(Integer authorId);

    // 특정 공모전 상세글의 모집글 조회
    List<RecruitmentPosts> findByCompetitionDetailsDetailsId(Integer detailsId);
}
