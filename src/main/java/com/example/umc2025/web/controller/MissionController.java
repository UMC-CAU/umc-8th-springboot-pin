package com.example.umc2025.web.controller;

import com.example.umc2025.apiPayload.ApiResponse;
import com.example.umc2025.domain.Mission;
import com.example.umc2025.service.MissionService;
import com.example.umc2025.web.converter.MissionConverter;
import com.example.umc2025.web.dto.MissionDTO;
import com.example.umc2025.web.dto.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(@RequestBody @Valid MissionDTO.AddDTO dto) {
        Mission mission = missionService.addMission(dto);
        return ApiResponse.onSuccess(MissionConverter.toResultDTO(mission));
    }
}
