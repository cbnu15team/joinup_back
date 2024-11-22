package com.example.joinup3.controller;

import com.example.joinup3.entity.Notice;
import com.example.joinup3.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    // 모든 공지 조회
    @GetMapping
    public List<Notice> getAllNotices() {
        return noticeService.getAllNotices();
    }

    // 특정 공지 조회
    @GetMapping("/{noticeId}")
    public Notice getNoticeById(@PathVariable Long noticeId) {
        return noticeService.getNoticeById(noticeId);
    }

    // 공지 생성
    @PostMapping
    public Notice createNotice(@RequestBody Notice notice) {
        return noticeService.createNotice(notice);
    }

    // 공지 수정
    @PutMapping("/{noticeId}")
    public Notice updateNotice(@PathVariable Long noticeId, @RequestBody Notice updatedNotice) {
        return noticeService.updateNotice(noticeId, updatedNotice);
    }

    // 공지 삭제
    @DeleteMapping("/{noticeId}")
    public String deleteNotice(@PathVariable Long noticeId) {
        noticeService.deleteNotice(noticeId);
        return "Notice deleted successfully";
    }
}
