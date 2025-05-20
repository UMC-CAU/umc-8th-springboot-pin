package com.example.umc2025.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberMissionRequestDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class addRequestDTO {
        Long memberId;
        Long missionId;
    }
}
