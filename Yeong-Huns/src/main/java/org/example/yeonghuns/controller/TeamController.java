package org.example.yeonghuns.controller;

import org.example.yeonghuns.dto.team.response.GetAllTeamsResponse;
import org.example.yeonghuns.service.team.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team")
    public ResponseEntity<Void> createTeam(@RequestParam String name){
        teamService.createTeam(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/team")
    public ResponseEntity<List<GetAllTeamsResponse>> getAllTeams(){
        List<GetAllTeamsResponse> allTeamsList = teamService.getAllTeams();
        return ResponseEntity.ok().body(allTeamsList);
    }
}
