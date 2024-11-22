package com.example.joinup3.service;

import com.example.joinup3.entity.CompetitionPage;
import com.example.joinup3.repository.CompetitionPageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionPageService {

    private final CompetitionPageRepository competitionPageRepository;

    public CompetitionPageService(CompetitionPageRepository competitionPageRepository) {
        this.competitionPageRepository = competitionPageRepository;
    }

    // 모든 공모전 조회
    public List<CompetitionPage> getAllCompetitions() {
        return competitionPageRepository.findAll();
    }

    // 특정 공모전 조회
    public CompetitionPage getCompetitionById(Integer competitionId) {
        return competitionPageRepository.findById(competitionId)
                .orElseThrow(() -> new RuntimeException("Competition not found with id: " + competitionId));
    }

    // 공모전 생성
    public CompetitionPage createCompetition(CompetitionPage competitionPage) {
        return competitionPageRepository.save(competitionPage);
    }

    // 공모전 수정
    public CompetitionPage updateCompetition(Integer competitionId, CompetitionPage updatedCompetition) {
        CompetitionPage existingCompetition = getCompetitionById(competitionId);
        existingCompetition.setTitle(updatedCompetition.getTitle());
        existingCompetition.setDeadline(updatedCompetition.getDeadline());
        existingCompetition.setViews(updatedCompetition.getViews());
        return competitionPageRepository.save(existingCompetition);
    }

    // 공모전 삭제
    public void deleteCompetition(Integer competitionId) {
        CompetitionPage competition = getCompetitionById(competitionId);
        competitionPageRepository.delete(competition);
    }
}
