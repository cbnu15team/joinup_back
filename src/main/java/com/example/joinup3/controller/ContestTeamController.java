package com.example.joinup3.controller;

import com.example.joinup3.entity.ContestTeam;
import com.example.joinup3.service.ContestTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contest-teams")
public class ContestTeamController {

    private final ContestTeamService contestTeamService;

    @Autowired
    public ContestTeamController(ContestTeamService contestTeamService) {
        this.contestTeamService = contestTeamService;
    }

    // Create a new Contest Team
    @PostMapping
    public ResponseEntity<ContestTeam> createContestTeam(@RequestBody ContestTeam contestTeam) {
        return ResponseEntity.ok(contestTeamService.createContestTeam(contestTeam));
    }

    // Get all Contest Teams
    @GetMapping
    public ResponseEntity<List<ContestTeam>> getAllContestTeams() {
        return ResponseEntity.ok(contestTeamService.getAllContestTeams());
    }

    // Get a Contest Team by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContestTeam> getContestTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(contestTeamService.getContestTeamById(id));
    }

    // Delete a Contest Team
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContestTeam(@PathVariable Long id) {
        contestTeamService.deleteContestTeam(id);
        return ResponseEntity.noContent().build();
    }
}
