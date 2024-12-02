package com.keyin.golfclubapi.controller;

import com.keyin.golfclubapi.model.Member;
import com.keyin.golfclubapi.model.Tournament;
import com.keyin.golfclubapi.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public Tournament createOrUpdateTournament(@RequestBody Tournament tournament) {
        return tournamentService.saveTournament(tournament);
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Optional<Tournament> getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTournamentById(@PathVariable Long id) {
        tournamentService.deleteTournamentById(id);
    }

    @PostMapping("/{tournamentId}/add-member/{memberId}")
    public Tournament addMemberToTournament(@PathVariable Long tournamentId, @PathVariable Long memberId) {
        return tournamentService.addMemberToTournament(tournamentId, memberId);
    }

    @GetMapping("/search/by-start-date")
    public List<Tournament> searchTournamentsByStartDate(@RequestParam String startDate) {
        LocalDate date = LocalDate.parse(startDate);
        return tournamentService.searchTournamentsByStartDate(date);
    }

    @GetMapping("/search/by-location")
    public List<Tournament> searchTournamentsByLocation(@RequestParam String location) {
        return tournamentService.searchTournamentsByLocation(location);
    }

    @GetMapping("/{tournamentId}/members")
    public List<Member> getAllMembersInTournament(@PathVariable Long tournamentId) {
        return tournamentService.getAllMembersInTournament(tournamentId);
    }
}
