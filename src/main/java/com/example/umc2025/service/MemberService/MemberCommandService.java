package com.example.umc2025.service.MemberService;

import com.example.umc2025.domain.Member;
import com.example.umc2025.domain.Rating;
import com.example.umc2025.domain.mapping.MemberMission;
import com.example.umc2025.web.dto.MemberRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface MemberCommandService {


    Member joinMember(MemberRequestDTO.JoinDto request);

    Member findById(Long id);

    Page<Rating> getRatingList(Long memberId, Integer page);

    Page<MemberMission> getTryingMissionMissionList(Long memberId, Integer page);
}
