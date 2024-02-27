package org.example.yeonghuns.service.team;

import org.example.yeonghuns.domain.Team;
import org.example.yeonghuns.dto.team.response.GetAllTeamsResponse;
import org.example.yeonghuns.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    @Transactional
    public void createTeam(String name){
        if(teamRepository.existsByName(name)) throw new IllegalArgumentException("존재하는 팀입니다.");
        teamRepository.save(new Team(name));
    }

    public List<GetAllTeamsResponse> getAllTeams(){
        return teamRepository.findAll().stream().map(Team::toResponse).toList();
    }
}
