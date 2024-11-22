package com.example.joinup3.controller;

import com.example.joinup3.entity.CompetitionDetails;
import com.example.joinup3.service.CompetitionDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition-details")
public class CompetitionDetailsController {

    private final CompetitionDetailsService competitionDetailsService;

    public CompetitionDetailsController(CompetitionDetailsService competitionDetailsService) {
        this.competitionDetailsService = competitionDetailsService;
    }

    // 모든 상세글 조회
    @GetMapping
    public List<CompetitionDetails> getAllDetails() {
        return competitionDetailsService.getAllDetails();
    }

    // 특정 상세글 조회
    @GetMapping("/{detailsId}")
    public CompetitionDetails getDetailsById(@PathVariable Integer detailsId) {
        return competitionDetailsService.getDetailsById(detailsId);
    }

    // 상세글 생성
    @PostMapping
    public CompetitionDetails createDetails(@RequestBody CompetitionDetails competitionDetails) {
        return competitionDetailsService.createDetails(competitionDetails);
    }

    // 상세글 수정
    @PutMapping("/{detailsId}")
    public CompetitionDetails updateDetails(@PathVariable Integer detailsId, @RequestBody CompetitionDetails updatedDetails) {
        return competitionDetailsService.updateDetails(detailsId, updatedDetails);
    }

    // 상세글 삭제
    @DeleteMapping("/{detailsId}")
    public String deleteDetails(@PathVariable Integer detailsId) {
        competitionDetailsService.deleteDetails(detailsId);
        return "Details deleted successfully";
    }
}
