package com.example.joinup3.repository;

import com.example.joinup3.entity.CompetitionPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionPageRepository extends JpaRepository<CompetitionPage, Integer> {
    // 기본 CRUD 메서드 제공 (findAll, findById, save, delete 등)
}
