package com.example.joinup3.controller;

import com.example.joinup3.entity.Contest;
import com.example.joinup3.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contests")
public class ContestController {

    private final ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    // Create a new contest
    @PostMapping
    public ResponseEntity<Contest> createContest(@RequestBody Contest contest) {
        // 실제 생성 로직을 서비스로 위임
        Contest created = contestService.createContest(contest);

        // 생성된 Contest 객체를 HTTP 응답으로 반환
        return ResponseEntity.ok(created);
    }

    // Get all contests
    @GetMapping
    public ResponseEntity<List<Contest>> getAllContests() {
        List<Contest> contests = contestService.getAllContests();
        return ResponseEntity.ok(contests);
    }

    // Get a contest by ID
    @GetMapping("/{id}")
    public ResponseEntity<Contest> getContestById(@PathVariable Long id) {
        Contest contest = contestService.getContestById(id);
        return ResponseEntity.ok(contest);
    }

    // Update a contest
    @PutMapping("/{id}")
    public ResponseEntity<Contest> updateContest(@PathVariable Long id, @RequestBody Contest contest) {
        Contest updatedContest = contestService.updateContest(id, contest);
        return ResponseEntity.ok(updatedContest);
    }

    // Delete a contest
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContest(@PathVariable Long id) {
        contestService.deleteContest(id);
        return ResponseEntity.noContent().build();
    }
}
