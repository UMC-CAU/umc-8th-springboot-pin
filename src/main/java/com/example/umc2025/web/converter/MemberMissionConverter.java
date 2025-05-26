package com.example.umc2025.web.converter;

import com.example.umc2025.domain.mapping.MemberMission;
import com.example.umc2025.web.dto.MemberMissionRequestDTO;
import com.example.umc2025.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.addResultDTO toAddResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.addResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionId(memberMission.getMission().getId())
                .memberId(memberMission.getMember().getId())
                .build();
    }
}
