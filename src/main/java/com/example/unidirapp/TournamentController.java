package com.example.unidirapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TournamentController {

    final TournamentRepo tournamentRepo;

    @Autowired
    public TournamentController(TournamentRepo tournamentRepo) {
        this.tournamentRepo = tournamentRepo;
    }

    @PostMapping("/add")
    public Tournament addTournament(@RequestBody Tournament inputTournament,
                                @RequestParam("team1") String team1,
                                @RequestParam("team2") String team2,
                                @RequestParam("matchName") String matchName)
    {
        Tournament tournament = new Tournament();
        tournament.setName(inputTournament.getName());

        CricketMatch match = new CricketMatch();
        match.setMatchName(matchName);
        match.setTeam1(team1);
        match.setTeam2(team2);

        tournament.getCricketMatches().add(match);
        Tournament savedTournament = tournamentRepo.save(tournament);
        return savedTournament;
    }
}
