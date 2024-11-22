package com.example.joinup3.service;

import com.example.joinup3.entity.Notice;
import com.example.joinup3.repository.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    // 모든 공지 조회
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    // 특정 공지 조회
    public Notice getNoticeById(Long noticeId) {
        return noticeRepository.findById(noticeId)
                .orElseThrow(() -> new RuntimeException("Notice not found with id: " + noticeId));
    }

    // 공지 생성
    public Notice createNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    // 공지 수정
    public Notice updateNotice(Long noticeId, Notice updatedNotice) {
        Notice existingNotice = getNoticeById(noticeId); // 기존 공지 조회
        existingNotice.setTitle(updatedNotice.getTitle());
        existingNotice.setContent(updatedNotice.getContent());
        existingNotice.setUploadDate(updatedNotice.getUploadDate());
        return noticeRepository.save(existingNotice);
    }

    // 공지 삭제
    public void deleteNotice(Long noticeId) {
        Notice notice = getNoticeById(noticeId);
        noticeRepository.delete(notice);
    }
}
