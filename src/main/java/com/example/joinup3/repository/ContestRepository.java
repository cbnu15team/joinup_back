package com.example.joinup3.repository;

import com.example.joinup3.entity.Contest;
import com.example.joinup3.entity.Contest.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContestRepository extends JpaRepository<Contest, Long> {

    // Find contests by category
    List<Contest> findByCategory(Category category);

    // Find contests with a title containing a keyword
    List<Contest> findByTitleContaining(String keyword);
}
