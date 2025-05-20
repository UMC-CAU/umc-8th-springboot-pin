package com.example.umc2025.domain.mapping;

import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mission mission;

    public MemberMission( Member member, Mission mission) {
        this.status = MissionStatus.TRYING;
        this.member = member;
        this.mission = mission;
    }

    public void setMember(Member member) {
        this.member = member;
        if (!member.getMemberMissionList().contains(this) && member != null) {
            member.getMemberMissionList().add(this);
        }
    }

    public void setMission(Mission mission) {
        this.mission = mission;
        if (!mission.getMemberMission().contains(this) && mission != null) {
            mission.getMemberMission().add(this);
        }
    }
}
