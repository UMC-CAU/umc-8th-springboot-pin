package com.example.umc2025.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class MissionDTO {

    @Getter
    public static class AddDTO {

        @NotNull
        String missionName;

        String missionCertificationNumber;

        @NotNull
        Long storeId;

        List<Long> memberMisssion;
    }
}
