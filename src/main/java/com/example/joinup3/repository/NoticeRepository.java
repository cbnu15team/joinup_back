package com.example.joinup3.repository;

import com.example.joinup3.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    // 기본 CRUD 메서드 지원: save, findById, findAll, deleteById 등
}
