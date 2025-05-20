package com.example.umc2025.web.controller;

import com.example.umc2025.apiPayload.ApiResponse;
import com.example.umc2025.domain.Mission;
import com.example.umc2025.service.MissionService;
import com.example.umc2025.web.converter.MissionConverter;
import com.example.umc2025.web.dto.MissionDTO;
import com.example.umc2025.web.dto.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/add")
    public ApiResponse<MissionResponseDTO.AddMissionResultDTO> addMission(@RequestBody @Valid MissionDTO.AddDTO dto) {
        Mission mission = missionService.addMission(dto);
        return ApiResponse.onSuccess(MissionConverter.toResultDTO(mission));
    }
}
