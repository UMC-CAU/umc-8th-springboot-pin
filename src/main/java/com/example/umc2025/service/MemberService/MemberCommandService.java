package com.example.umc2025.service.MemberService;

import com.example.umc2025.domain.Member;
import com.example.umc2025.web.dto.MemberRequestDTO;

import java.util.Optional;
import java.util.OptionalInt;

public interface MemberCommandService {


    Member joinMember(MemberRequestDTO.JoinDto request);

    Optional<Member> findById(Long id);
}
