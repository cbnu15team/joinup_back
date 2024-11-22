package com.example.joinup3.service;

import com.example.joinup3.entity.CompetitionDetails;
import com.example.joinup3.repository.CompetitionDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionDetailsService {

    private final CompetitionDetailsRepository competitionDetailsRepository;

    public CompetitionDetailsService(CompetitionDetailsRepository competitionDetailsRepository) {
        this.competitionDetailsRepository = competitionDetailsRepository;
    }

    // 모든 상세글 조회
    public List<CompetitionDetails> getAllDetails() {
        return competitionDetailsRepository.findAll();
    }

    // 특정 상세글 조회
    public CompetitionDetails getDetailsById(Integer detailsId) {
        return competitionDetailsRepository.findById(detailsId)
                .orElseThrow(() -> new RuntimeException("Details not found with id: " + detailsId));
    }

    // 상세글 생성
    public CompetitionDetails createDetails(CompetitionDetails competitionDetails) {
        return competitionDetailsRepository.save(competitionDetails);
    }

    // 상세글 수정
    public CompetitionDetails updateDetails(Integer detailsId, CompetitionDetails updatedDetails) {
        CompetitionDetails existingDetails = getDetailsById(detailsId);
        existingDetails.setTitle(updatedDetails.getTitle());
        existingDetails.setContent(updatedDetails.getContent());
        existingDetails.setImageUrl(updatedDetails.getImageUrl());
        existingDetails.setParticipation(updatedDetails.getParticipation());
        return competitionDetailsRepository.save(existingDetails);
    }

    // 상세글 삭제
    public void deleteDetails(Integer detailsId) {
        CompetitionDetails details = getDetailsById(detailsId);
        competitionDetailsRepository.delete(details);
    }
}
