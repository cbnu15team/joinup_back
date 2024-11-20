package com.example.joinup3.service;

import com.example.joinup3.entity.ContestTeam;
import com.example.joinup3.repository.ContestTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestTeamService {

    private final ContestTeamRepository contestTeamRepository;

    @Autowired
    public ContestTeamService(ContestTeamRepository contestTeamRepository) {
        this.contestTeamRepository = contestTeamRepository;
    }

    // Create a new Contest Team
    public ContestTeam createContestTeam(ContestTeam contestTeam) {
        return contestTeamRepository.save(contestTeam);
    }

    // Get all Contest Teams
    public List<ContestTeam> getAllContestTeams() {
        return contestTeamRepository.findAll();
    }

    // Get a Contest Team by ID
    public ContestTeam getContestTeamById(Long id) {
        return contestTeamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contest Team not found with ID: " + id));
    }

    // Delete a Contest Team
    public void deleteContestTeam(Long id) {
        contestTeamRepository.deleteById(id);
    }
}
