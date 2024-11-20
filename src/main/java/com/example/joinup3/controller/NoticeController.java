package com.example.joinup3.controller;

import com.example.joinup3.entity.Notice;
import com.example.joinup3.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 공지사항 생성
    @PostMapping("/create")
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        Notice createdNotice = noticeService.createNotice(notice);
        return ResponseEntity.ok(createdNotice);
    }

    // 모든 공지사항 조회
    @GetMapping
    public ResponseEntity<List<Notice>> getAllNotices() {
        List<Notice> notices = noticeService.getAllNotices();
        return ResponseEntity.ok(notices);
    }

    // 특정 공지사항 조회
    @GetMapping("/{noticeId}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable Long noticeId) {
        Notice notice = noticeService.getNoticeById(noticeId);
        return ResponseEntity.ok(notice);
    }

    // 공지사항 수정
    @PutMapping("/{noticeId}")
    public ResponseEntity<Notice> updateNotice(@PathVariable Long noticeId, @RequestBody Notice notice) {
        Notice updatedNotice = noticeService.updateNotice(noticeId, notice);
        return ResponseEntity.ok(updatedNotice);
    }

    // 공지사항 삭제
    @DeleteMapping("/{noticeId}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long noticeId) {
        noticeService.deleteNotice(noticeId);
        return ResponseEntity.noContent().build();
    }
}
