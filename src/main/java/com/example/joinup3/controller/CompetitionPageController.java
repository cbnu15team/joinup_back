package com.example.joinup3.controller;

import com.example.joinup3.entity.CompetitionPage;
import com.example.joinup3.service.CompetitionPageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition-pages")
public class CompetitionPageController {

    private final CompetitionPageService competitionPageService;

    public CompetitionPageController(CompetitionPageService competitionPageService) {
        this.competitionPageService = competitionPageService;
    }

    // 모든 공모전 조회
    @GetMapping
    public List<CompetitionPage> getAllCompetitions() {
        return competitionPageService.getAllCompetitions();
    }

    // 특정 공모전 조회
    @GetMapping("/{competitionId}")
    public CompetitionPage getCompetitionById(@PathVariable Integer competitionId) {
        return competitionPageService.getCompetitionById(competitionId);
    }

    // 공모전 생성
    @PostMapping
    public CompetitionPage createCompetition(@RequestBody CompetitionPage competitionPage) {
        return competitionPageService.createCompetition(competitionPage);
    }

    // 공모전 수정
    @PutMapping("/{competitionId}")
    public CompetitionPage updateCompetition(@PathVariable Integer competitionId, @RequestBody CompetitionPage updatedCompetition) {
        return competitionPageService.updateCompetition(competitionId, updatedCompetition);
    }

    // 공모전 삭제
    @DeleteMapping("/{competitionId}")
    public String deleteCompetition(@PathVariable Integer competitionId) {
        competitionPageService.deleteCompetition(competitionId);
        return "Competition deleted successfully";
    }
}
