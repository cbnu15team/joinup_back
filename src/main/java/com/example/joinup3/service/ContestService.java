package com.example.joinup3.service;

import com.example.joinup3.entity.Contest;
import com.example.joinup3.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestService {

    private final ContestRepository contestRepository;

    @Autowired
    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    // Create a new contest
    public Contest createContest(Contest contest) {
        return contestRepository.save(contest);
    }

    // Get all contests
    public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }

    // Get contest by ID
    public Contest getContestById(Long contestId) {
        return contestRepository.findById(contestId)
                .orElseThrow(() -> new RuntimeException("Contest not found with ID: " + contestId));
    }

    // Get contests by category
    public List<Contest> getContestsByCategory(Contest.Category category) {
        return contestRepository.findByCategory(category);
    }

    // Update a contest
    public Contest updateContest(Long contestId, Contest updatedContest) {
        Contest contest = getContestById(contestId);
        contest.setTitle(updatedContest.getTitle());
        contest.setDDay(updatedContest.getDDay());
        contest.setCategory(updatedContest.getCategory());
        return contestRepository.save(contest);
    }

    // Delete a contest
    public void deleteContest(Long contestId) {
        contestRepository.deleteById(contestId);
    }
}
