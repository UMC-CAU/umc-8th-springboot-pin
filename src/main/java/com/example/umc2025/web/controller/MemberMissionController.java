package com.example.umc2025.web.controller;

import com.example.umc2025.apiPayload.ApiResponse;
import com.example.umc2025.domain.mapping.MemberMission;
import com.example.umc2025.service.MemberMissionService.MemberMissionService;
import com.example.umc2025.web.converter.MemberMissionConverter;
import com.example.umc2025.web.dto.MemberMissionRequestDTO;
import com.example.umc2025.web.dto.MemberMissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memberMission")
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/add")
    public ApiResponse<MemberMissionResponseDTO.addResultDTO> addMemberMission(@RequestBody @Valid MemberMissionRequestDTO.addRequestDTO requestDTO) {
        MemberMission memberMission = memberMissionService.addMemberMission(requestDTO);
        return ApiResponse.onSuccess(MemberMissionConverter.toAddResultDTO(memberMission));
    }
}
