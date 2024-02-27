package org.example.yeonghuns.service.member;

import org.example.yeonghuns.domain.Member;
import org.example.yeonghuns.domain.Team;
import org.example.yeonghuns.dto.member.request.SaveMemberRequest;
import org.example.yeonghuns.dto.member.response.GetAllMembersResponse;
import org.example.yeonghuns.repository.MemberRepository;
import org.example.yeonghuns.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveMember(SaveMemberRequest request){
        Team team = teamRepository.findByName(request.getTeamname()).orElseThrow(IllegalArgumentException::new);
        if(request.getIsManager()){ updateManager(team, request);}
        memberRepository.save(request.toEntity(team));
    }
    public void updateManager(Team team, SaveMemberRequest request){
        if(team.getManager().isEmpty()) team.updateManager(request.get);
    }

    public List<GetAllMembersResponse> getAllMembers(){
        return memberRepository.findAll().stream().map(Member::toResponse).toList();
    }
}
