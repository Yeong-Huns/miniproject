package org.example.yeonghuns.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.yeonghuns.dto.team.response.GetAllTeamsResponse;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String manager;
    @OneToMany(mappedBy = "team")
    List<Member> memberList = new ArrayList<>();

    public Team() {}
    public Team(String name){this.name=name;}



    public GetAllTeamsResponse toResponse(){
        return GetAllTeamsResponse.builder()
                .name(name)
                .manager(manager)
                .memberCount(memberList.size())
                .build();
    }
}
