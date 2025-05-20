package com.example.umc2025.repository.memberMissionRepository;


import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Mission;
import com.example.umc2025.domain.enums.MissionStatus;
import com.example.umc2025.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {

    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest request);

    List<MemberMission> findAllByMemberAndMission(Member member, Mission mission);
}
