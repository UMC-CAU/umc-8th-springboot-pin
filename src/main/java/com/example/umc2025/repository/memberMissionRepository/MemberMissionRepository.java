package com.example.umc2025.repository.memberMissionRepository;


import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.enums.MissionStatus;
import com.example.umc2025.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {

    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest request);
}
