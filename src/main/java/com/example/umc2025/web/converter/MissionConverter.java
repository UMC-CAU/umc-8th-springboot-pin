package com.example.umc2025.web.converter;

import com.example.umc2025.domain.Mission;
import com.example.umc2025.web.dto.MissionDTO;
import com.example.umc2025.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MissionConverter {

    public static Mission toMission(MissionDTO.AddDTO request) {

        return Mission.builder()
                .missionName(request.getMissionName())
                .missionCertificationNumber(request.getMissionCertificationNumber())
                .memberMission(new ArrayList<>())
                .build();
    }

    public static MissionResponseDTO.AddMissionResultDTO toResultDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
