package com.example.umc2025.web.dto;

import lombok.Builder;
import lombok.Getter;

public class MemberMissionRequestDTO {

    @Builder
    @Getter
    public static class addRequestDTO {
        Long memberId;
        Long missionId;
    }
}
