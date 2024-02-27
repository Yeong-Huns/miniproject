package org.example.yeonghuns.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.example.yeonghuns.dto.member.response.GetAllMembersResponse;

import java.time.LocalDate;
@Entity
@Getter
public class Member {

    protected Member() {}

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String teamName;
    @Column
    private boolean role;
    @Column
    private LocalDate birthday;
    @Column
    private LocalDate workStartDate;
    @ManyToOne
    private Team team;
    public GetAllMembersResponse toResponse(){
        String isManager = this.role?"MANAGER":"MEMBER";

        return GetAllMembersResponse.builder()
                .name(name)
                .teamName(teamName)
                .role(isManager)
                .birthday(birthday)
                .workStartDate(workStartDate)
                .build();
    }
    @Builder
    public Member(String name, String teamName, boolean role, LocalDate birthday, LocalDate workStartDate, Team team) {
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
        this.team = team;
    }

    public void changeRole(){
        this.role = !this.role;
    }
}
