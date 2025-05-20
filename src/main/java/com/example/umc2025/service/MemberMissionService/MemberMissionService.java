package com.example.umc2025.service.MemberMissionService;

import com.example.umc2025.domain.mapping.MemberMission;
import com.example.umc2025.web.dto.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface MemberMissionService {
    MemberMission addMemberMission(MemberMissionRequestDTO.addRequestDTO requestDTO);
}
