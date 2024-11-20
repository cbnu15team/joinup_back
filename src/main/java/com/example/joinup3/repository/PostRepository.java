package com.example.joinup3.repository;

import com.example.joinup3.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Find posts by user ID
    List<Post> findByUserUserId(Long userId);

    // Find posts containing a keyword in the title
    List<Post> findByTitleContaining(String keyword);
}
