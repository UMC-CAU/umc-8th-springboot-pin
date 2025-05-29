package com.example.umc2025.web.dto;

import com.example.umc2025.domain.mapping.MemberMission;
import lombok.Builder;
import lombok.Getter;

public class MemberMissionResponseDTO {

    @Builder
    @Getter
    public static class addResultDTO {
        private Long memberMissionId;
        private Long memberId;
        private Long missionId;
    }
}
