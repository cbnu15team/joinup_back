package com.example.joinup3.service;

import com.example.joinup3.entity.Notice;
import com.example.joinup3.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    // 공지사항 생성
    public Notice createNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    // 모든 공지사항 조회
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    // 특정 공지사항 조회
    public Notice getNoticeById(Long noticeId) {
        return noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("공지사항을 찾을 수 없습니다: " + noticeId));
    }

    // 공지사항 수정
    public Notice updateNotice(Long noticeId, Notice updatedNotice) {
        Notice notice = getNoticeById(noticeId);
        notice.setTitle(updatedNotice.getTitle());
        return noticeRepository.save(notice);
    }

    // 공지사항 삭제
    public void deleteNotice(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }
}
